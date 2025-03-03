{
"version": 1,
"author": "Anonymous maker",
"editor": "wokwi",
"parts": [
{ "type": "wokwi-breadboard", "id": "bb1", "top": -70.2, "left": -131.6, "attrs": {} },
{
"type": "wokwi-esp32-devkit-v1",
"id": "esp",
"top": 32.9,
"left": -73.8,
"rotate": 90,
"attrs": {}
},
{
"type": "wokwi-servo",
"id": "servo1",
"top": 53.8,
"left": -344.6,
"rotate": 90,
"attrs": { "horn": "double" }
},
{
"type": "wokwi-led-ring",
"id": "ring1",
"top": 239.96,
"left": -152.79,
"rotate": 180,
"attrs": { "pixels": "16" }
}
],
"connections": [
[ "esp:TX0", "$serialMonitor:RX", "", [] ],
[ "esp:RX0", "$serialMonitor:TX", "", [] ],
[ "bb1:tn.3", "bb1:5t.a", "black", [ "v0" ] ],
[ "bb1:5t.e", "bb1:5b.f", "black", [ "v0" ] ],
[ "bb1:4b.f", "bb1:4t.e", "red", [ "v0" ] ],
[ "bb1:tp.2", "bb1:4t.a", "red", [ "v0" ] ],
[ "bb1:tp.1", "servo1:V+", "red", [ "v0.3", "h-135.2" ] ],
[ "servo1:GND", "bb1:tn.1", "black", [ "v0" ] ],
[ "servo1:PWM", "bb1:6t.a", "green", [ "v-124.8", "h191.8" ] ],
[ "bb1:6b.f", "bb1:6t.e", "green", [ "v0" ] ],
[ "ring1:GND", "esp:GND.1", "black", [ "v0" ] ],
[ "ring1:VCC", "esp:3V3", "red", [ "v0" ] ],
[ "ring1:DIN", "esp:D15", "green", [ "v0" ] ],
[ "esp:VIN", "bb1:4b.j", "", [ "$bb" ] ],
[ "esp:GND.2", "bb1:5b.j", "", [ "$bb" ] ],
[ "esp:D13", "bb1:6b.j", "", [ "$bb" ] ],
[ "esp:D12", "bb1:7b.j", "", [ "$bb" ] ],
[ "esp:D14", "bb1:8b.j", "", [ "$bb" ] ],
[ "esp:D27", "bb1:9b.j", "", [ "$bb" ] ],
[ "esp:D26", "bb1:10b.j", "", [ "$bb" ] ],
[ "esp:D25", "bb1:11b.j", "", [ "$bb" ] ],
[ "esp:D33", "bb1:12b.j", "", [ "$bb" ] ],
[ "esp:D32", "bb1:13b.j", "", [ "$bb" ] ],
[ "esp:D35", "bb1:14b.j", "", [ "$bb" ] ],
[ "esp:D34", "bb1:15b.j", "", [ "$bb" ] ],
[ "esp:VN", "bb1:16b.j", "", [ "$bb" ] ],
[ "esp:VP", "bb1:17b.j", "", [ "$bb" ] ],
[ "esp:EN", "bb1:18b.j", "", [ "$bb" ] ]
],
"dependencies": {}
}
