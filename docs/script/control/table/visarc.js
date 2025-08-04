import * as tablem from './table.js'
import * as rpgm from '../rpg.js'

const ADORATOR=new tablem.Table('Visio Arcana, character, adorator',
                                  ['Judger','Martyr','Penant','Priest','Reaver','Tyrant'])
const LIME=new tablem.Table('Visio Arcana, character, indictus, lime',
                            ['Defender','Messenger','Singer'])
const GAOL=new tablem.Table('Visio Arcana, character, indictus, gaol',
                            ['Crazy','Cruel','Rover'])
const INDICTUS=new tablem.Table('Visio Arcana, character, indictus',[LIME,GAOL])
const ATER=new tablem.Table('Visio Arcana, character, ater',
                            ['Avatar','Fairy','Ghast','Shifter','Undead','Witch'])

export class Character extends tablem.Table{
  constructor(){
    super('Visio Arcana, character')
    this.add(ADORATOR,3)
    this.add(LIME,1)
    this.add(GAOL,1)
    this.add(ATER,1)
  }
}

export class Region extends tablem.Table{
  constructor(){super('Visio Arcana, region')}

  roll(){
    let regions=['Gaol','Saltmarsh Sepulchre','Obsidian Mire','Sunderlands',
                  'Gloomwood Heartlands','Skyshroud Valleys','Lime',]
    let i=3
    let roll=1
    while(!(3<=roll&&roll<=5)){
      roll=rpgm.roll(1,6)
      if(roll==6) i+=1
      else if(roll<=2) i-=1
    }
    return regions[rpgm.bind(0,i,regions.length-1)]
  }
}

export var tables=[ADORATOR,LIME,GAOL,INDICTUS,ATER,new Character(),new Region()]
