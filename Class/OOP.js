//JavaScript OOP was introduced in ES2015

//defines a class called Assassin
class Assassin{
    //the constructor instantiates the 3 instance variables name, timePeriod, and game which now when declaring a new object, the correct variables can be used properly in methods that you create
    constructor(name,timePeriod,game) {
        this.name = name;
        this.timePeriod = timePeriod;
        this.game = game;
    }
    //essentially a static method/ instance method in javascript
    statement(){
        return "My name is " + this.name + " and I live in " + this.timePeriod + " and my game is " + this.game;
    }
    //class methods combine individual instances for a method or are general utility methods
    //must be called by Class_Name.method();
    static assassinDuo(Assassin1, Assassin2){
        return "This duo is " + Assassin1.name + " and " + Assassin2.name;
    }
}

//new object called Bayek
var Bayek = new Assassin("Bayek","Hellenistic Egypt", "AC Origins" );
//can access object properties
console.log(Bayek.timePeriod);

//new object called Alexios with no game parameter
var Alexios = new Assassin("Alexios", "Hellenistic Egypt")
//undefined if you try to access Alexios.game
console.log(Alexios.game);
//adds a game value manually (can add keys and values outside of the constructor parameters if needed)
Alexios.game = "AC Odyssey"
console.log(Alexios.game);

//calls instance method on Bayek stating his characteristics
console.log(Bayek.statement());

//calls class method
console.log(Assassin.assassinDuo(Bayek,Alexios));
