# Minim

Minim is a full, lightweight [tabletop roleplaying system](https://en.wikipedia.org/wiki/Tabletop_role-playing_game) that uses only normal dice (six-sided ones, also know as d6) and can be used to play any RPG style or genre. In this repository you will find 3 independent (but related) projects:

1. The Minim system in itself, which is an 11-page booklet focusing on fun-and-fast rules for your gaming sessions;
2. The GM Companion for Minim, which is a software that helps a gamemaster run a session with minimal pre-planning and also handles as much dice-rolling and rules as you'll let it - meaning that you can focus entirely on what's important: having fun and telling stories with your friends;
3. A simple script to helps you manage a soundtrack while you run your games.

We'll now dive into each ot these in more detail.

# The Minim role-playing system

Minim is the *minimalistic* role-playing system and it tries to offer as much potential as those other systems that come in expensive books with hundreds of pages of rules. It leaves a lot of work to the imagination of players and GMs alike but it does so while providing an established foundation which you should be able to easily expand upon and derive your own ideas from.

The system has been put to use and tested with a variety of scenarios and groups of people and holds up to the task fairly well in any situation. It will never be as detailed for fantasy games as D&D is, for example, with decades of excellent work put into it - but it doesn't try to! It focuses on letting the story flow fast and for interesting situations to always appear during a gaming session - and not on deciding only between your attack hitting or missing or the exact composition of a wizard's spellbook, down to the very last level-zero cantrip.

If you're looking for something more traditional like that then the Companion (detailed below) will also not be of any value to you - but if the premise of Minim sounds interesting to you so far then make sure to read on as [the entire system is free to read  and use](https://github.com/tukkek/minim/raw/master/doc/minim.pdf)! You will also find ready-to-print character sheets in the ["doc" folder](https://github.com/tukkek/minim/tree/master/doc) - which, in the same spirit should allow you and your players to get started in a matter of around 15 minutes of character creation if you're familiar enough with the rules to guide them through the process.

# The GM companion

The Minim Gamemaster Companion is the largest part of this repository. It allows you to create virtual characters for your games (both for player and GM characters), roll dice and resolve actions with it, eliminating as much overhead as possible to allow you and your players to focus in the game itself and not on the rules and dice around the game. Minim is already a lightweight system designed with the same sort of philosophy in mind - when allied with this Companion program it can really bring role-playing to the next level, especially for those gaming groups interested more in the story and fast-and-furious combat, instead of memorizing and looking up rules or battle rounds that can take over 10 minutes to finish - as those who are familiar with traditional role-playing systems will surely be familiar with.

One of the biggest strengths of the Companion for the gamemaster is to reduce pre-planning as much as possible: with it by your side you don't need to flesh out entire sets of monsters and characters before you can even start playing - you can focus on your dungeon design or story and not have to worry about countless stats even before the game begins! Once your group enters an encounter, all you have to do is add the appropriate units in the companion and it will only ask you about their specific stats (skill levels, gear, current damage, etc) when absolutely necessary, remembering that information so it doesn't have to ask you again and never bothering you with anything unrelated to the checks that need to be made for the encounter to run through to completion. 

This can be a great help for GMs who want to try improvising part of their games, as it's easier to just enter the relevant data into the program using your best judgement as a DM than to have to write it all down so you don't forget during the rest of the encounter. Just tell the Companion which actors will be in a scene and what actions are being taken and it will handle as much as possible for you - from combat to group tasks and even managing damage levels or determining initiaitve! We'd all love to have more time to prepare our games but the Companion makes it easier to pick up the slack so that you can focus on the meaningful things when you're writing your adventures, and not on the mechanics of your game!

**What the Companion is not:** the companion is not a replacement for coming up with an awesome adventure for your group, great dungeon designs, terrific monstrous foes or memorable figures to inhabit your game world. All it tries to do is take care of all the mechanical parts of a game session so that everything else can progress as smoothly as possible. It also knows that some of these mechanical tasks are better left for the players, who will want to roll some things on their own and keep track of their most important information themselves. The Companion makes no attempt at managing the heroes' special abilities, willpower pools or equipment - a skilled GM will know how to use it to the fullest and when to let the players roll their own dice and resolve their own actions manually.

You can download the Companion's [latest relase for your operating system on the releases page](https://github.com/tukkek/minim/releases). You will require [Java 8 or higher](https://java.com/inc/BrowserRedirect1.jsp?locale=en) in order to run it.

If instead you want to compile the source code yourself then you will need:

* Java Development Kit (Version 8 or higher) http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html
* Eclipse RCP (version 4 or higher) http://www.eclipse.org/downloads/eclipse-packages/

A little bit about the Companion's history: it was first created around 2008 as a New World of Darkness companion software, with much of the same goals as it has today. In 2013 it was converted to the Minim roleplaying system (at the time called "Base 5"). The current version is a rewrite from scratch, turning the old 10-thousand lines-of-code previous project into around one thousand LoC only. The previous incarnation was a little bit fancier but they are, for all intents and purposes, equivalent solutions.

# Soundtrack management

This is only a simple script which could go unnoticed if not featured here in the manual. If you have an organized collection of music tracks to use as a backdrop for your gaming sessions, this will help you manage them as effortlessly as possible during the course of a gaming session. For this to work you'll need:

1. [Python 3](https://www.python.org/downloads/) installed in your computer.
2. The [VLC media player](https://www.videolan.org/vlc/) installed as well.
3. Minimal knowledge about how to use a command-line program.
4. A folder where you have different genres of music separated into subfolders (for example: a folder for action tracks, another for drama, yet another for suspense, etc).

What this script does is to list your folders and allow you to select one. When you do, it will launch VLC in random mode and automatically start playing them. As soon as you close VLC it will once again show you your folder selection so you can change between moods as fast as possible, without having to worry about handling playlists, finding your folders or anything else that can be a bit of a bother, especially if you're trying to tell an amazing story at your gaming table instead.

The command line usage is simply `python3 soundchooser.py [your main folder location]`. So on Windows it could become something like `python3 soundchooser.py "c:\my songs\"`or, on UNIX, something like `./soundchooser.py ~/soundtrack/`.

This originally had a more friendly user-interface but due to technology changes that version stopped working - it was rewritten as a command-line utility to ensure a longer lifespan and independence from third-party graphical libraries.
