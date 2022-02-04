import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Xylophone App',
      home: XylophonePage(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class XylophonePage extends StatefulWidget {
  const XylophonePage({ Key? key }) : super(key: key);

  @override
  _XylophonePageState createState() => _XylophonePageState();
}

class _XylophonePageState extends State<XylophonePage> {
  final colors = [
    Colors.red,
    Colors.orange,
    Colors.yellow,
    Colors.green,
    Colors.blue,
    Colors.indigo,
    Colors.purple
  ];

  final player = AudioCache();

  void _playSound(int noteNumber) {
    player.play('note$noteNumber.wav');
  }

  List<Widget> _getItem() {
    List<Widget> tiles = [];

    for (int i=0; i< colors.length; i++) {
      tiles.add(
        Expanded(
          child: TextButton(
            style: TextButton.styleFrom(backgroundColor: colors[i]),
            onPressed: () {
              _playSound(i + 1);
            },
            child: Text(
              '${i+1}',
              style: const TextStyle(
                color: Colors.white,
                fontSize: 25,
                fontWeight: FontWeight.bold
              ),
            ),
          )
        ),
      );
    }
    return tiles;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: _getItem(),
        ),
      ),
    );
  }
}