import * as unit from '../model/unit.js'

export function start(){
  if(true) return
  let u=new unit.Unit('a').save()
  u.affect('effect 1')
  u.affect('effect 2')
//   new unit.Unit('a2').save()
}
