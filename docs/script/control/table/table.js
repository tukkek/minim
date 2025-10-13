import * as tablem from '../../../lib/table/table.js'

export class Table extends tablem.Table{
  constructor(name,rows=[]){
    super(name,rows)
    this.end='.'
  }
}
