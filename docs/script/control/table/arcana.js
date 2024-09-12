import * as table from './table.js'

const COURAGE=new table.Table('Courage',['Scared','Hesitant','Careful','Brave','Fearless'])
const POWER=new table.Table('Power',['Sick','Meager','Hardy','Strong','Champion'])
const WEALTH=new table.Table('Wealth',['Destitute','Poor','Mid-class','High-class','Elite'])
const COMPASSION=new table.Table('Compassion',['Cold','Distant','Sympathetic','Compassionate','Saintly'])
const PERSONALITY=new table.Table('Arcana (personality)',[COURAGE,POWER])
const NATURE=new table.Table('Arcana (nature)',[WEALTH,COMPASSION])
const INTELLECT=new table.Table('Arcana (theme, intellect)',['Stupidity','Ignorance','Competence','Intelligence','Brilliance'])
const CREATIVITY=new table.Table('Arcana (theme, creativity)',['Shallowness','Blandness','Pedestry','Creativity','Artistry'])
const EXPRESSION=new table.Table('Arcana (theme, self-expression)',['Distance','Timidity','Reticence','Eloquence','Leadership'])
const EMPATHY=new table.Table('Arcana (theme, empathy)',['Hostility','Apathy','Reflection','Compassion','Altruism'])
const HEALTH=new table.Table('Arcana (theme, health)',['Infermity','Frailty','Resilience','Vigor','Purity'])
const THEME=new table.Table('Arcana (theme)',[INTELLECT,CREATIVITY,EXPRESSION,EMPATHY,HEALTH])

class Character extends table.Table{
  constructor(){
    super('Arcana (character)')
  }
  
  roll(){
    let traits=[PERSONALITY,NATURE].map((t)=>t.roll()).sort()
    traits=traits.join(' and ').toLowerCase()
    traits=traits[0].toUpperCase()+traits.slice(1)
    let t=THEME.roll().toLowerCase()
    return `${traits} (theme: ${t})`
  }
}

export var tables=[PERSONALITY,NATURE,new Character(),INTELLECT,CREATIVITY,EXPRESSION,EMPATHY,HEALTH,THEME]
