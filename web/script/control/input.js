var listeners=[]

function press(key){
  let a=document.activeElement
  if(a.id=='notes'){
    if(key=='Escape') a.blur()
    return
  }
  let l=listeners[listeners.length-1]
  if(l) l(key)
}

export function setup(){window.onkeyup=e=>press(e.key)}

export function listen(callback){listeners.push(callback)}

export function deafen(callback){
  let i=listeners.indexOf(callback)
  if(i>=0) listeners.splice(i,1)
}
