#!/usr/bin/python
'''
Requires:

- Python 3 https://www.python.org/downloads/
- VLC https://www.videolan.org/
'''

import subprocess,string,os,sys

if len(sys.argv)==1:
    raise Exception('Usage: soundsetter.py [target folder]')
target=os.path.join(os.getcwd(),sys.argv[1])
folders=list()
for folder in os.listdir(target):
  if os.path.isdir(os.path.join(target,folder)):
    folders.append(folder)
folders=sorted(folders)
while True:
  for i in range(0,len(folders)):
    print(string.ascii_lowercase[i]+' - '+folders[i])
  print('')
  subprocess.call(['vlc','-Z',os.path.join(target,folders[string.ascii_lowercase.index(raw_input('Type all the letters you want to include in this search: ').lower())])])
  print('')
