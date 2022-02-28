import 'package:flutter/material.dart';
import 'package:prog_4/question.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Quiz App',
      theme: ThemeData(
        primarySwatch: Colors.purple,
      ),
      debugShowCheckedModeBanner: false,
      home: const QuizPage(),
    );
  }
}

class QuizPage extends StatefulWidget {
  const QuizPage({ Key? key }) : super(key: key);

  @override
  _QuizPageState createState() => _QuizPageState();
}

class _QuizPageState extends State<QuizPage> {
  List<Question> questions = [
    Question(questionText: "Question 1", answer: true),
    Question(questionText: "Question 2", answer: true),
    Question(questionText: "Question 3", answer: false),
    Question(questionText: "Question 4", answer: true),
    Question(questionText: "Question 5", answer: false),
    Question(questionText: "Question 6", answer: false),
    Question(questionText: "Question 7", answer: false),
  ];

  int _currScore = 0;
  int _quesNum = 0;

  void checkAnswer(bool answer, bool choice) {
    if (answer == choice) {
      setState(() {
        _currScore++;
      });
    }

    setState(() {
      _quesNum++;
    });
  }

  void reset() {
    setState(() {
      _currScore = 0;
      _quesNum = 0;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Quiz App'),
      ),
      body: Center(
        child: _quesNum <  questions.length
          ? Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text(
                  'Current Score : $_currScore',
                  style: const TextStyle(
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold
                  ),
                ),
                const SizedBox(height: 50.0),
                Text(
                  questions[_quesNum].questionText,
                  style: const TextStyle(
                    fontSize: 40.0, 
                    fontWeight: FontWeight.bold
                  ),
                ),
                const SizedBox(height: 50.0),
                ElevatedButton(
                  onPressed: () => 
                    checkAnswer(questions[_quesNum].answer, true), 
                  child: const Text('True')
                ),
                ElevatedButton(
                  onPressed: () => 
                    checkAnswer(questions[_quesNum].answer, false), 
                  child: const Text('False')
                ),                
              ],
            )
          : Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Text(
                  'Your Final Score is $_currScore',
                  style: const TextStyle(
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold
                  ),
                ),
                ElevatedButton(
                  onPressed: reset,
                  child: const Text('Play again'))
              ],
          )
      ),
    );
  }
}



