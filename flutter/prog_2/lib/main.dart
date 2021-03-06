import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: Scaffold(
          backgroundColor: Colors.red,
          appBar: AppBar(
            title: const Text('Dice App'),
            backgroundColor: Colors.red,
          ),
          body: const DicePage(),
        ));
  }
}

class DicePage extends StatefulWidget {
  const DicePage({Key? key}) : super(key: key);

  @override
  _DicePageState createState() => _DicePageState();
}

class _DicePageState extends State<DicePage> {
  int _left = 1;
  int _right = 2;

  void _rollADice() {
    setState(() {
      _left = Random().nextInt(6) + 1;
      _right = Random().nextInt(6) + 1;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        children: <Widget>[
          Expanded(
            flex: 1,
            child: TextButton(
              child: Image.asset('images/dice$_left.png'),
              onPressed: _rollADice,
            ),
          ),
          Expanded(
            flex: 1,
            child: TextButton(
              child: Image.asset('images/dice$_right.png'),
              onPressed: _rollADice,
            ),
          )
        ],
      ),
    );
  }
}
