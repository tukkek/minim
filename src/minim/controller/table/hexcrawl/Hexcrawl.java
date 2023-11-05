package minim.controller.table.hexcrawl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import minim.controller.table.Table;
import minim.controller.table.hexcrawl.Hex.Hexagon;

/** TODO hexagonal map */
public class Hexcrawl extends Table{
  public static final Hexcrawl SMALL=new Hexcrawl(3);
  public static final Hexcrawl BIG=new Hexcrawl(5);

  static final int LINE=100;

  String letters="abcdefghijklmnopqrstuvwxyz";
  int size;

  Hexcrawl(int size){
    super("Hexcrawl (%sx%s)".formatted(size,size));
    this.size=size;
  }

  @Override
  public void build(){
    // don't
  }

  String join(List<String> map){
    return String.join("\n",map);
  }

  String space(List<String> chunks){
    chunks=new ArrayList<>(chunks);
    var blank=LINE-chunks.stream().mapToInt(c -> c.length()).sum();
    chunks.add(0,"");
    var space=blank / chunks.size();
    if(space<1) space=1;
    return String.join(" ".repeat(space),chunks);
  }

  String spread(List<String> labels){
    var nlabels=labels.size();
    var lines=new ArrayList<String>(nlabels / 2);
    List<String> line=null;
    for (var l : labels){
      if(line==null){
        line=new ArrayList<>(List.of(l));
        continue;
      }
      if(line.stream().mapToInt(chunk -> chunk.length()+1).sum()
          +l.length()>LINE){
        lines.add(space(line));
        line=new ArrayList<>(1);
      }
      line.add(l);
    }
    if(!line.isEmpty()) lines.add(space(line));
    return join(lines);
  }

  String print(List<String> labels,List<String> map,
      Map<Hexagon,Character> hexes){
    var interesting=hexes.keySet().stream().filter(h -> h.interest()).toList();
    interesting=new ArrayList<>(interesting);
    var poi=interesting.stream()
        .sorted(Comparator.comparing(i -> Character.toLowerCase(hexes.get(i))))
        .map(i -> "%s = %s".formatted(hexes.get(i),i.feature)).toList();
    return "%s\n\n%s\n\n%s".formatted(join(map),spread(poi),spread(labels));
  }

  @Override
  public String roll(){
    var legend=new HashMap<Hexagon,Character>(size * size);
    var hexes=new ArrayList<Hexagon>(size * size);
    var labels=new ArrayList<String>();
    var crawl=new Hexagon[size][size];
    var map=new ArrayList<String>();
    for (var y=0; y<size; y++){
      var shorter=y % 2==1;
      var line=shorter?"  ":"";
      for (var x=0; x<size-(shorter?1:0); x++){
        Hexagon h;
        if(x==0&&y==0) h=new Hexagon();
        else if(x==0&&y>0) h=crawl[0][y-1].next();
        else h=crawl[x-1][y].next();
        crawl[x][y]=h;
        hexes.add(h);
        var l=letters.charAt(legend.size());
        if(h.interest()) l=Character.toUpperCase(l);
        legend.put(h,l);
        line+=l + "  ";
        labels.add(
            "%s = %s".formatted(Character.toLowerCase(l),h.toString(false)));
      }
      map.add(line);
    }
    return print(labels,map,legend);
  }
}
