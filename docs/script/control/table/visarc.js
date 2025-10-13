import * as tablem from '../../control/table/table.js'
import * as realm from '../../control/table/real.js'
import * as rpgm from '../../control/rpg.js'

const ARCHAICS=['Judger','Martyr','Penant','Priest','Reaver','Tyrant']
const ADORATOR=new tablem.Table('Visio Arcana, character, adorator',ARCHAICS)
const LIME=new tablem.Table('Visio Arcana, character, indictus, lime',
                            ['Defender','Messenger','Singer'])
const GAOL=new tablem.Table('Visio Arcana, character, indictus, gaol',
                            ['Crazy','Cruel','Rover'])
const INDICTUS=new tablem.Table('Visio Arcana, character, indictus',[LIME,GAOL])
const ATER=new tablem.Table('Visio Arcana, character, ater',
                            ['Avatar','Fairy','Ghast','Shifter','Undead','Witch'])
const TOWNS=new tablem.Table('Visio Arcana, towns',ARCHAICS.map((text)=>`${text} town`))

class Character extends tablem.Table{
  constructor(){
    super('Visio Arcana, character')
    this.add(ADORATOR,60)
    this.add(LIME,20)
    this.add(GAOL,20)
    this.add(ATER,20)
    this.add('Luminosus',1)
  }

  roll(){
    let traits=['Brass','Brawl','Brain'].map((text)=>`${text} ${rpgm.mid(1,5)}`)
    return [
      `${super.roll()} (${traits.join(', ').toLowerCase()}).`,
      realm.simple.roll()
    ].join('<br>')
  }
}

class Region extends tablem.Table{
  constructor(name,foes,subregions=false){
    super(`Visio Arcana, region, ${name}`)
    this.foes=this.expand(foes)
    this.subregions=this.expand(subregions)
  }

  expand(items){
    if(!items) return new tablem.Table('_',[false])
    let table=new tablem.Table('_')
    for(let i=0;i<items.length;i+=1) table.add(items[i],i+1)
    table.add(false,table.rows.length)
    return table
  }

  roll(){
    let region=this.name.split(',').last.trim()
    let subregion=this.subregions.roll()
    if(subregion) region=`${region}, ${subregion}`
    return region
  }
}

class Regions extends tablem.Table{
  constructor(){super(`Visio Arcana, region`)}

  roll(){return regions[rpgm.mid(0,regions.length-1)].roll()}
}

class Reward extends tablem.Table{
  constructor(){
    super('Visio Arcana, reward')
    this.add('No reward',100)
    this.add('Lumen',10)
    this.add('Fragment',1)
  }
}

class Scene extends tablem.Table{
  constructor(){super('Visio Arcana, scene')}

  roll(){return [character,reward].map((table)=>table.roll()).join('<br>')}
}

export var regions=[new Region('Lime',['Machina-lucis','Lime']),
                    new Region('Sky-shroud',['Spectra','Turba'],['Shrine','Turba']),
                    new Region('Gloom',['Spora-vivae','Animalia'],['Plana-sporarum','Inner-woods']),
                    new Region('Heart-land',['Elicti',ADORATOR],['Cor Draconis',TOWNS]),
                    new Region('Ashen-mire',['Giant','Lacerta'],['Via-gigantus','Graze']),
                    new Region('Sepulcher-coast',['Colossaeus','Primo'],['Rust-sea','Sea']),
                    new Region('Gaol',['Roboratus','Gaol'])]
export var character=new Character()
export var reward=new Reward()
export var tables=[ADORATOR,LIME,GAOL,INDICTUS,ATER,character,
                    new Regions(),regions,TOWNS,reward,new Scene()].flat()
