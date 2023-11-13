import * as table from '../table.js'

export var tables=[]

const LOWER = "Lower";
const HIGHER = "Higher";

const NEXTELEVATION= new table.Table("Adventure, hexcrawl, elevation, next")
NEXTELEVATION.add(HIGHER,2);
NEXTELEVATION.add("Same",8-5);
NEXTELEVATION.add(LOWER,2);

var elevation = new table.Table("Adventure, hexcrawl, elevation",["Mountain", "Hill", "Plain", "Valley", "Lowland"])

tables.push(...[NEXTELEVATION,elevation])

const DRY = "Dry";
const DRYER = "Dryer";
const WETTER = "Wetter";
const NEXTWATER = new table.Table("Adventure, hexcrawl, water, next")
NEXTWATER.add(WETTER,1);
NEXTWATER.add("Same",8-5);
NEXTWATER.add(DRYER,1);
  
var water=new table.Table("Adventure, hexcrawl, water",["Sea", "Lake", "River", DRY])

tables.push(...[NEXTWATER,water])

const SPARSER = "Sparser";
const DENSER = "Denser";
const NEXTVEGETATION = new table.Table("Adventure, hexcrawl, vegetation, next")
NEXTVEGETATION.add(DENSER,1);
NEXTVEGETATION.add("Same",8-5);
NEXTVEGETATION.add(SPARSER,1);
    
var vegetation=new table.Table("Adventure, hexcrawl, vegetation",["Dense", "Forest", "Grassland", "Scrubland", "Barren"]);

tables.push(...[NEXTVEGETATION,vegetation])

const NONE = "None";
const TYPES = new table.Table("Adventure, hexcrawl, point of interest, types") 
TYPES.add("Ruins",2);
TYPES.add("Cave",2);
TYPES.add("Natural formation",2);
TYPES.add("Monster lair");
TYPES.add("NPC lair");
TYPES.add("Campsite",2);
TYPES.add("Settlement");
TYPES.add("Magic");
TYPES.add("Unusual terrain",2);

class PointOfInterest extends table.Table {
	constructor() {
		super("Adventure, hexcrawl, point of interest");
		this.add(NONE,10);
		this.add("Minor",4);
		this.add("Major");
	}
}

var interest=new PointOfInterest()

tables.push(...[TYPES, interest])

const NEXT=new table.Table("Adventure, hexcrawl, hex, next",[NEXTELEVATION,NEXTVEGETATION,NEXTWATER,interest]);

const CHARACTERISTICS=["Elevation","Vegetation",
    "Water","Point of interest"]

function next(current,t,next,lower,
      higher){
  let nexte=next.roll();
  let l=t.lines;
  let i=l.indexOf(current);
  if(nexte==higher&&i>0) i-=1;
  else if(nexte==lower&&i<l.length-1) i+=1;
  return l[i]
}
    
class Hexagon{
  constructor(e=false,v=false,w=false){
    this.elevation=e||elevation.roll()
    this.vegetation=v||vegetation.roll()
    this.water=w||water.roll()
    this.feature=interest.roll();
    if(this.interest()) this.feature=TYPES.roll();
  }

  interest(){
    return this.feature!=NONE;
  }

  toString(full=true){
    let s=this.vegetation + " " + this.elevation.toLowerCase();
    if(water!=DRY) s+=" by " + this.water.toLowerCase();
    if(full&&this.interest())
      s+=" (point of interest: " + this.feature.toLowerCase() + ")";
    return s;
  }

  next(){
    var e=next(this.elevation,elevation,NEXTELEVATION,LOWER,
        HIGHER);
    var v=next(this.vegetation,vegetation,NEXTVEGETATION,
        SPARSER,DENSER);
    var w=next(this.water,water,NEXTWATER,WETTER,DRYER);
    return new Hexagon(e,v,w);
  }
}

class Hex extends table.Table{
  constructor(){
    super("Adventure, hexcrawl, hex");
  }

  roll(){
    return new Hexagon().toString();
  }
}

tables.push(...[NEXT, new Hex()])

const LINE=100;
class Hexcrawl extends table.Table{
  constructor(size){
    super(`Adventure, ${size}x${size} hexcrawl`)
    this.letters="abcdefghijklmnopqrstuvwxyz";
    this.size=size;
  }

  join(map){
    return map.join('<br/>')
  }

  space(chunks){
    return chunks.join(" ")
//     let blank=LINE-chunks.map(c => c.length).reduce((a,b)=>a+b)
//     chunks.push(0,"");
//     let space=blank / chunks.length;
//     if(space<1) space=1;
//     return chunks.join(" ".repeat(space))
  }

  spread(labels){
    let nlabels=labels.length;
    let lines=[]
    let line=null;
    for (let l of labels){
      if(!line){
        line=[l]
        continue;
      }
      if(line.map(chunk => chunk.length+1).reduce((a,b)=>a+b)
          +l.length>LINE){
        lines.push(this.space(line));
        line=[]
      }
      line.push(l);
    }
    if(!line.length==0) lines.push(this.space(line));
    return this.join(lines);
  }

  print(labels,map,
      hexes){
    let interesting=Array.from(hexes.keys()).filter(h => h.interest())
    interesting=Array.from(interesting);
    var poi=Array.from(interesting)
    poi.sort((a,b) => hexes.get(a).toLowerCase().localeCompare(hexes.get(b).toLowerCase()))
    poi=poi.map(i =>hexes.get(i)+ " = "+i.feature)
    return [this.join(map),this.spread(poi),this.spread(labels)].join('<br/><br/>')
  }

  roll(){
    let legend=new Map()
    let hexes=[]
    let labels=[]
    let crawl=[]
    let s=this.size
    for(let i=0;i<s;i++) crawl[i]=[]
    let map=[]
    for (let y=0; y<s; y++){
      let shorter=y % 2==1;
      let line=shorter?"&nbsp;":"";
      for (let x=0; x<s-(shorter?1:0); x++){
        let h=false
        if(x==0&&y==0) h=new Hexagon();
        else if(x==0&&y>0) h=crawl[0][y-1].next();
        else h=crawl[x-1][y].next();
        crawl[x][y]=h;
        hexes.push(h);
        let l=this.letters[legend.size]
        if(h.interest()) l=l.toUpperCase()
        legend.set(h,l);
        line+=l + "  ";
        labels.push(
            [l.toLowerCase(),h.toString(false)].join(' = '))
      }
      map.push(line);
    }
    return this.print(labels,map,legend);
  }
}

const SMALL=new Hexcrawl(3);
const BIG=new Hexcrawl(5);

tables.push(...[SMALL,BIG])
