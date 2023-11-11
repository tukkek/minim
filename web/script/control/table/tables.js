import * as test from './test.js'

export var tables=[test]

export function setup(){tables=tables.flatMap(t=>t.tables)}
