# brick-breaking
------------------------------------------------------------------------------------------------------------------------
This project is basically aiming to stimulate the times of playing the old release of the game, known as Brick Breaker. 
First introduced in the year 2010 our project is trying to aim for a nostalgic yet different objective for the game. 
Compared to the original game, our is presented with an endless classic level. 


**Some interesting tech that we used in our project.**

* An enum (Enumerated type) for predefined state in our game(STARTMENU, PLAY , GAMEOVER and NEWGAME).
 
* A MouseListener (an interface) in order to get mouse click events.

* The draw method
  * The *drawBrick(graphics)* method and  *drawBall(graphics)* method to draw bricks and ball respectively.
  * The *drawPaddle(graphics,x)* method to draw paddle and specify its position by x value. 

* The *checkCollisions()* method to test when the ball touches a brick and the paddle by draws a rectangle that has the same size as the ball,the paddle and a brick and uses the intersects method (from rectangle class) to determines whether or not this Rectangle and the specified Rectangle intersect
