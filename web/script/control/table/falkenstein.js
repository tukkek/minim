import * as table from './table.js'

const BACKGROUND = new table.Table("Falkenstein, diary questions, background",
  ["What is your name?", "Where do you come from?", "What do you regret most?",
      "What are you most proud of?", "What have you been doing for the last few years?",
      "What has granted you social acclaim?", "Have you comitted a crime?",
      "What sort of education did you have?", "Where do you live now?"])
const APPEARANCE = new table.Table("Falkenstein, diary questions, appearance",
  ["What do you look like?", "What is your style?", "Describe your clothing preferences",
      "Describe your quirks.", "Are you dashing or demure?"])
const PERSONALITY = new table.Table("Falkenstein, diary questions, personality",
  ["What are your virtues and vices?", "What are your best qualities?",
      "Describe your personality in two words", "What principle do you value the most?",
      "What is your most treasured possession?", "What is your social goal?",
      "What is your professional goal?", "What gives you a sense of satisfaction?",
      "Would you give up your life for something? Why?"])
const PREFERENCES = new table.Table("Falkenstein, diary questions, preferences",
  ["What do you like?", "What do you dislike?", "Describe your favorite foods.",
      "Describe your favorite drinks.", "Describe your favorite books.", "Describe your favorite music.",
      "Describe your favorite places.", "Describe your least favorite foods.",
      "Describe your least favorite drinks.", "Describe your least favorite books.",
      "Describe your least favorite music.", "Describe your least favorite places."])
const ALLEGIANCES = new table.Table("Falkenstein, diary questions, allegiances",
  ["Who do you value most?", "Who is your nemesis?", "What do you stand against?",
      "Who are your allies?", "Do you have friends?", "Do you look up to someone?",
      "who are your heroes?", "Would you give up your life for someone? Why?"])
const SKILLS = new table.Table("Falkenstein, diary questions, skills",
  ["What ability are you great at?", "What ability are you poor at?",
      "Describe four abilities you're good at?", "How do you make a living?",
      "What activites do you enjoy outside of work?", "What would be your dream job?"])
const ROMANCE = new table.Table("Falkenstein, diary questions, romance",
  ["Describe your romantic life.", "What is your romantic goal?", "Did you ever abandon a lover?",
      "Have you ever not acted upon your heart's desires?",
      "Are you romantically involved and with whom?", "Are there obstacles in your way to love?"])
const FAMILY = new table.Table("Falkenstein, diary questions, family",
  ["Describe your childhood and upbringing.", "Do you have siblings?", "Are your parents around?",
      "Were you a legitimate or bastard child?",
      "How did you get along with your family as a young person?",
      "How do you get along with your family nowadays?", "Is your family wealthy?",
      "What are the important events in your family's history?",
      "What are the tragic events in your family's history?"])

var diary=new table.Table("Falkenstein, diary questions",[BACKGROUND, APPEARANCE, PERSONALITY, PREFERENCES, ALLEGIANCES, SKILLS, ROMANCE, FAMILY])

export var tables=[diary].concat(diary.lines)
