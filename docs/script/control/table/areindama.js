import * as tablem from '../../control/table/table.js'
import * as rpgm from '../../control/rpg.js'

const COALESCO='Coalesco'
const MEGASTRUCTURE='Megastructure'
const RUBBLE='Rubble'
const RUINS='Ruins'
const WATER='Water-way'
const DEEPWATER='Deep water-way'
const TERRAINS=[COALESCO,MEGASTRUCTURE,RUBBLE,RUINS,WATER,DEEPWATER]
const PAD=Math.max(...TERRAINS.map((text)=>text.length))

class District extends tablem.Table{
  constructor(name,rows=[]){
    super(`Areindama, 3X3 district, ${name.toLowerCase()}`)
    for(let row of rows) this.add(row)
  }

  form(common=false,normal=false,rare=COALESCO){
    if(common) this.add(common,3)
    if(normal) this.add(normal,2)
    if(rare) this.add(rare,1)
    return this
  }

  static map(name,table){
    name=name[0].toUpperCase()+name.slice(1)
    let rows=[]
    for(let i=0;i<3;i+=1)
      rows.push(Array.from(new Array(3),()=>rpgm.pick(table.lines).padEnd(PAD,'')))
    return [
      `${name} district.`,
      '',
      rows.map((row)=>row.join(' | ')),
    ].flat().join('<br/>')
  }

  roll(){
    let name=this.name.split(', ')
    name=name[name.length-1]
    return District.map(name,this)
  }
}

class Random extends tablem.Table{
  constructor(){super('Areindama, 3X3 district')}

  roll(){
    let tables=1
    while(rpgm.chance(2)) tables+=1
    tables=rpgm.shuffle(districts).slice(0,tables)
    let name=tables.map((table)=>table.name.split(', ')[2]).sort().join(', ')
    let table=new tablem.Table('Districts',tables.map((table)=>table.lines).flat())
    return District.map(name,table)
  }
}

var dustland=new District('Dust-land').form(RUBBLE,RUINS)
var garden=new District('Garden',[DEEPWATER,WATER,WATER,RUBBLE,RUBBLE,COALESCO])
var glassier=new District('Glassier').form(COALESCO,RUBBLE,MEGASTRUCTURE)
var lake=new District('Great-lake').form(DEEPWATER,WATER)
var industrial=new District('Industrial').form(RUINS,MEGASTRUCTURE)
var megaruin=new District('Megaruin').form(MEGASTRUCTURE,RUINS)
var districts=[dustland,garden,glassier,lake,industrial,megaruin]

export var tables=[districts,new Random()].flat()
