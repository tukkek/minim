import * as db from './db.js'

const VIEW=document.querySelector('#notes')

export var notes=VIEW

export async function setup(){VIEW.onkeyup=db.store}
