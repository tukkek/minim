import * as table from './table.js'

const FIRE=new table.Table('Fire',['Ash','Ember','Kindling','Pyre','Hearth'])
const WATER=new table.Table('Water',['Desert','Oasis','Mountain','Forest','Jungle'])
const EARTH=new table.Table('EARTH',['Misery','Poverty','Struggle','Comfort','Abundance'])
const AIR=new table.Table('AIR',['Storm','Gale','Calm','Gust','Zephyr'])
const REALMS=new table.Table('Arcana (realms)',['Hell','Umbra','Eden','Astral','Heaven'])
const ARCANA=new table.Table('Arcana',[WATER,AIR,FIRE,EARTH,REALMS])

class Character extends table.Table{
  constructor(){super('Arcana (character)')}

  roll(){
    let mood=new table.Table('Arcana (mood)',[FIRE,WATER])
    let nature=new table.Table('Arcana (nature)',[FIRE,WATER])
    let traits=`Mood: ${mood}; nature: ${nature}`
    return traits[0].toUpperCase()+traits.slice(1).toLowerCase()
  }
}

export var tables=[ARCANA,new Character()]
