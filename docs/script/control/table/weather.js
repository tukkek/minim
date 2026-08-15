import * as tablem from './table.js' 

class Table extends tablem.Table{
  constructor(name,weather){
    super(name)
    this.more=weather.hard
    this.same=weather.mild
    this.less=weather.easy
  }
  
  create(){
    this.add(this.less,3)
    this.add(this.same,2)
    this.add(this.more)
    return this
  }
}

class Easy extends Table{
  constructor(name,weather){
    super(name,weather)
    this.more=weather.mild
    this.same=weather.easy
    this.less=weather.easy
  }
}

class Hard extends Table{
  constructor(name,weather){
    super(name,weather)
    this.more=weather.hard
    this.same=weather.hard
    this.less=weather.mild
  }
}

class Weather{
  constructor(name='Temperate'){
    this.name=name.toLowerCase()
    this.easy='Clear'
    this.mild='Rain'
    this.hard='Storm'
  }
  
  create(){
    let name=`Weather, ${this.name}`
    return [
      new Easy(name,this),
      new Table(`${name}, ${this.mild.toLowerCase()}`,this),
      new Hard(`${name}, ${this.hard.toLowerCase()}`,this),
    ].map((table)=>table.create())
  }
}

class Hot extends Weather{
  constructor(){
    super('Hot')
    this.easy='Hot'
    this.mild='Windy'
  }
}

class Cold extends Weather{
  constructor(){
    super('Cold')
    this.easy='Cold'
    this.mild='Snow'
    this.hard='Blizzard'
  }
}

export var tables=[new Weather(),new Hot(),new Cold()]
  .map((weather)=>weather.create()).flat()
