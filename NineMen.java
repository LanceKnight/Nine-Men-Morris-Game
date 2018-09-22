import java.io.*;
import java.util.*;


public class NineMen{
	public static void main(String args[] ){

		NineMen test = new NineMen();
		String new_board = new String();
		LinkedList<String> list = new LinkedList<String>();
		String mode = "1";
		String result = "";
		int turn = 0;
		boolean end = false;
		boolean invalid = false;
		boolean invalid1 = false;
		boolean invalid2 = false;
		boolean invalid3 = false;
		int possibleMoves[];

		

			Scanner sc = new Scanner(System.in);
			String board = new String();

			int num = 0;
			while( invalid == true ){// input checking
					System.out.println("\nPlease input the position:");
				

					num = Integer.valueOf (sc.nextLine());
					possibleMoves = test.neighbors( num );  // get all possible moves
					for(int i = 0; i < 4; i ++ ){
						if( possibleMoves[i] != -1 ){
							if( board.charAt(possibleMoves[i]) != 'x' )
							{
								possibleMoves[i] = -1;
							}
						}
					
					}
					System.out.println("The possible moves for you are:");
					for( int i = 0; i < 4; i++ ){
						if (possibleMoves[i] != -1 ){
							System.out.println( possibleMoves[i] );
						}
					}

			}
			invalid = true;


			board = "xxxxxxxxxxxxxxxxxxxxxxxx";
			while ( end == false ){
					
				switch( mode ){//for input, if in game opening, switch mode to 1, if in mid or end game, switch to 2
					case "1":
					while( invalid == true ){
						System.out.println("\nPlease input the position:");
					

						num = Integer.valueOf (sc.nextLine());
						if( (board.charAt(num) == 'B' || board.charAt(num) =='W' )|| num > 23 || num < 0 ){// check input validity
							System.out.println("Invalid Input ");
							invalid = true;
						}else{
							invalid = false;
						
						}
					}
					invalid = true;
					
					StringBuilder sb = new StringBuilder( board );
					sb.setCharAt( num, 'B' );
					board = new String(sb);	


					if( test.closeMill( num, board )){// if close mill,  remove opponent piece
						
						invalid2 = true;
						while(invalid2 == true ){ // check input validity
							System.out.println("You close mill! Remove opponent piece in position:");
								
							num = Integer.valueOf( sc.nextLine());
							if( board.charAt( num ) != 'W' ){ // check input validity
								System.out.println("Invalid Input");
								invalid2 = true;
							}
							else{
								invalid2 = false;
							}
						}
						invalid2 = true;
						board = test.generateRemoveUser( board, num ); // remove opponent piece
						System.out.println( "board after your removing:");
						test.draw(board); // draw picture

					}
					break;

					case "2":// for user, if in mid or end game
						int numBlack = 0;
						int numWhite = 0;
						for( int i = 0; i < 24; i++ ){
							int position = board.charAt( i );
							if( position == 'B' ){
								numBlack++;
							}
							else if ( position == 'W' ){
								numWhite++;
							}
		
						}
						


						if( numBlack == 3 ){	// if the number of black equals to 3
		
							System.out.println("=======User Hopping======");	
							invalid1 = true;
							while( invalid1 == true ){
								System.out.println("\nPlease input the position:");				

								num = Integer.valueOf(sc.nextLine());
								if( board.charAt( num  ) != 'B'  ){ // check input validity
									System.out.println("Invalid input!");
									invalid1 = true;
								}
								else{
									invalid1 = false;
								}
							}
							invalid1 = true;

							sb = new StringBuilder( board );
							sb.setCharAt( num, 'x' );
							System.out.println("Please input where you want to go");
							num = Integer.valueOf( sc.nextLine());
			
							sb.setCharAt( num, 'B');
							board = new String(sb);	


							if( test.closeMill( num, board )){
							
							invalid2 = true;
							while(invalid2 == true ){
								System.out.println("You close mill! Remove opponent piece in position:");
									
								num = Integer.valueOf( sc.nextLine());
								if( board.charAt( num ) != 'W' ){ // check validity
									System.out.println("Invalid Input");
									invalid2 = true;
								}
								else{
									invalid2 = false;
								}
							}
							invalid2 = true;
							board = test.generateRemoveUser( board, num ); // remove opponent's piece
							System.out.println( "board after your removine:");
							test.draw(board);
							}
						}
						else{
							System.out.println("\nPlease input the position:");
					

							//num = Integer.valueOf (sc.nextLine());
							
							invalid3 = true;
							while( invalid3 == true ){
								num = Integer.valueOf(sc.nextLine());
								if( board.charAt(num) != 'B' ){
									System.out.println("Invalid Input");
									invalid3 = true;
								}
								else{
									invalid3 = false;
								}

							}
							invalid3 = true;

							sb = new StringBuilder( board );
							sb.setCharAt( num, 'x' );
							possibleMoves = test.neighbors( num );
							for(int i = 0; i < 4; i ++ ){
								if( possibleMoves[i] != -1 ){
									if( board.charAt(possibleMoves[i]) != 'x' )
									{
										possibleMoves[i] = -1;
									}
								}		
							
							}

							System.out.println("The possible moves for you are:");
							for( int i = 0; i < 4; i++ ){
								if (possibleMoves[i] != -1 ){
									System.out.println( possibleMoves[i] );
								}
							}

							System.out.println("Please choose from above value:");
							num = Integer.valueOf( sc.nextLine());

				
							sb.setCharAt( num, 'B');
							board = new String(sb);	


							if( test.closeMill( num, board )){
							
							
								invalid2 = true;
								while(invalid2 == true ){
									System.out.println("You close mill! Remove opponent piece in position:");
										
									num = Integer.valueOf( sc.nextLine());
									if( board.charAt( num ) != 'W' ){
										System.out.println("Invalid Input");
										invalid2 = true;
									}
									else{
										invalid2 = false;
									}
								}
								invalid2 = true;
								board = test.generateRemoveUser( board, num );
								System.out.println( "board after your removing:");
								test.draw(board);

							}
						}

						numWhite = 0;
						for( int i = 0; i < 24; i++ ){
							int position = board.charAt( i );
							if( position == 'B' ){
								numBlack++;
								}
							else if ( position == 'W' ){
								numWhite++;
							}
						}
							if(numWhite == 2){
								System.out.println("You win!!");
								System.exit(1);
							}
						
					break;
				}

				System.out.println("\nComputer is making move");
				switch( mode ){
					case "1":
						list = test.miniMaxOpening( board );
						if( list.size() != 0 ){
							result = test.pickBoard( list, 1 );
						
							System.out.println( result );//------------------------------
						}
						else{
							System.out.println("You win!");
							end = true;
						}
						break;
					case "2":
						list = test.miniMaxGame( board );
						//System.out.println( "list.size: "+ list.size() );
						result = test.pickBoard( list, 2 );
						System.out.println( result );
						break;
				}
				test.draw( result );
				board = result;
				turn++;
				if ( turn == 5 ){
					mode = "2";
					System.out.println("=========MidGame!========");
				}
				//Process process = rt.exec("java Draw board2.txt");
                	} 
			
	}

	void draw( String board ){ // draw the picture
	

			System.out.println( board.charAt( 21 ) + "--------" + board.charAt( 22 ) + "--------" + board.charAt( 23 ) );
			System.out.println( "|        |        |" );
			System.out.println( "|  " + board.charAt( 18 ) + "-----" + board.charAt( 19 ) + "-----" + board.charAt( 20 ) + "  |" );
			System.out.println( "|  |     |     |  |" );
			System.out.println( "|  |  " + board.charAt( 15 ) + "--" + board.charAt( 16 ) + "--" + board.charAt( 17 ) + "  |  |");
			System.out.println( "|  |  |     |  |  |" );
			System.out.println( board.charAt( 9 ) + "--" + board.charAt( 10 ) + "--" + board.charAt( 11 ) + "     " + board.charAt( 12 ) + "--" + board.charAt( 13 ) + "--" + board.charAt( 14 ) );
			System.out.println( "|  |  |     |  |  |" );
			System.out.println( "|  |  " + board.charAt( 6 ) + "--" + board.charAt( 7 ) + "--" + board.charAt( 8 ) + "  |  |" );
			System.out.println( "|  |     |     |  |" );
			System.out.println( "|  " + board.charAt( 3 ) + "-----" + board.charAt( 4 ) + "-----" + board.charAt( 5 ) + "  |" );
			System.out.println( "|        |        |" );
			System.out.println( board.charAt( 0 ) + "--------" + board.charAt( 1 ) + "--------" + board.charAt( 2 ) );
			
		
	
	}


	LinkedList<String> miniMaxOpening( String board ){ // For opening
		return generateMovesOpening( board );	
	}

	LinkedList<String> miniMaxGame( String board ){ // For mid and end games
		return generateMovesMidgameEndgame( board );
	}



	LinkedList<String> generateMovesOpening( String board ){ // generate moves for opening
		return generateAdd( board );
		
	}



	LinkedList<String> generateMovesMidgameEndgame( String board ){ // generate moves in mid or end game
		LinkedList<String> list = new LinkedList<String>();
		char position;
		int numWhite = 0;
		
		for( int i = 0; i < 24; i++ ){
			if( board.charAt( i ) == 'W' ){
				numWhite++;
			}
		} 

		if( numWhite == 3 ){
			return generateHopping( board );
		}
		else{
			return generateMove( board );
		}
		
	
	
	}






	LinkedList<String> generateAdd( String board ){ // generate add 
		LinkedList<String> list = new LinkedList<String>();
		char position;
		
		//StringBuilder sb = new StringBuilder();

		for( int i = 0; i < 24; i ++){
			position = board.charAt( i );
			if( position == 'x' ){
				//System.out.println("hello");
				StringBuilder sb = new StringBuilder( board );
				sb.setCharAt( i, 'W' );
				//System.out.println( new String( sb ) );

				if( closeMill( i, new String( sb ) ) ){
					generateRemove( new String( sb ), list );
					System.out.println("Computer closes mill!One of your pieces is removed!");	
				}
				else{
					list.add( new String( sb ) );
					
				}
			}
		}
		return list;
		
	}







	LinkedList<String> generateHopping( String board ){ // generate hopping
		LinkedList<String> list = new LinkedList<String>();
		char position1;
		char position2;
	        System.out.println("=======Computer Hopping=============");	

		for( int i = 0; i < 24; i++){
			position1 = board.charAt( i );
			
			if( position1 == 'W' ){
				for( int j = 0; j < 24; j++ ){
					position2 = board.charAt( j );
					if( position2 == 'x' ){
						
						StringBuilder sb = new StringBuilder( board );
						sb.setCharAt( i, 'x' );
						sb.setCharAt( j, 'W' );
						if( closeMill( j, new String( sb ) ) ){
							generateRemove( board, list );
						}
						else{
							list.add( new String( sb ) );
						
						}
						
						
						
					}
				
					
				
				}
			
			}
		}
		return list;
	
	}



	LinkedList<String> generateMove( String board ){ // generate moves
		LinkedList<String> list = new LinkedList<String>();
		int[] n = new int[4];
		char position;
		boolean added = false;

		for( int i = 0; i < 24; i++){
			position = board.charAt( i );
			if( position == 'W' ){
				n = neighbors( i );
				

				for( int j = 0; j < 4; j++ ){
					if( n[ j ] != -1 ){
						if( board.charAt( n[ j ] ) == 'x' ){
							StringBuilder sb = new StringBuilder( board );
							sb.setCharAt( i, 'x' );
							sb.setCharAt( n[ j ], 'W' );
							if( closeMill( n[ j ], new String( sb ) ) ){
								generateRemove( new String( sb ), list );
				
								System.out.println("Computer closes mill! One of your pieces is removed!");
							}
							else{
								list.add( new String( sb ) );
							}
						}


					}
				}
				
			
			}
		
		}


		
		return list;
	}










	LinkedList<String> generateRemove( String board, LinkedList<String> list ){ // generate remove from white's point of view( i,e, remove black)
		char position;
		boolean added = false;

		for( int i = 0; i < 24; i++ ){
			position = board.charAt( i );

			if( position == 'B' ){
				if( !closeMill( i, board ) ){
					StringBuilder sb = new StringBuilder( board );
					sb.setCharAt( i, 'x' );
					list.add( new String( sb ) );
					added = true;
				}
			}
		
		}

		if( added == false ){
			list.add( board );
		}
		return list;
	
	}


	String generateRemoveUser( String board, int position ){  // generate remove from user's point of view( i.e, remove white)
			StringBuilder sb = new StringBuilder();	
		

					sb = new StringBuilder( board );
					sb.setCharAt( position, 'x' );


			
		return new String(sb);

	}



	int[] neighbors( int input ){ // get the neighing position
	
		switch( input ){
			case 0:
				return new int[]{ 1, 9, -1, -1 };
			case 1:
				return new int[]{ 0, 2, 4, -1 };
			case 2:
				return new int[]{ 1, 14, -1, -1 };
			case 3:
				return new int[]{ 4, 10, -1, -1 };
			case 4: 
				return new int[]{ 1, 3, 5, 7 };
			case 5:
				return new int[]{ 4, 13, -1, -1 };
			case 6:
				return new int[]{ 11, 7, -1, -1 };
			case 7:
				return new int[]{ 6, 4, 8, -1 };
			case 8:
				return new int[]{ 7, 12, -1, -1 };
			case 9: 
				return new int[]{ 0, 10, 21, -1 };
			case 10:
				return new int[]{ 3, 9, 11, 18 };
			case 11:
				return new int[]{ 6, 10, 15, -1 };
			case 12:
				return new int[]{ 8, 13, 17, -1 };
			case 13:
				return new int[]{ 12, 5, 14, 20 };
			case 14:
				return new int[]{ 2, 13, 23, -1 };
			case 15:
				return new int[]{ 11, 16, -1, -1 };
			case 16:
				return new int[]{ 15, 17, 19, -1 };
			case 17:
				return new int[]{ 16, 12, -1, -1 };
			case 18:
				return new int[]{ 10, 19, -1, -1 };
			case 19:
				return new int[]{ 18, 16, 20, 22 };
			case 20:
				return new int[]{ 13, 19, -1, -1 };
			case 21:
				return new int[]{ 9, 22, -1, -1 };
			case 22:
				return new int[]{ 21, 19, 23, -1 };
			case 23:
				return new int[]{ 14, 22, -1, -1 };
		}
		return null;	
	}









	boolean closeMill( int x, String board ){ // check whether close  mill
		char c = board.charAt( x );
		switch( x ){
			case 0:
				if( ( ( board.charAt( 1 ) == c ) && ( board.charAt( 2 ) == c ) ) || ( ( board.charAt( 9 ) == c ) && ( board.charAt( 21 ) == c ) ) ){
					return true;
				}
				else{
					return false;
				}
			
			case 1:
				if( ( ( board.charAt( 0 ) == c ) && ( board.charAt( 2 ) == c ) ) || ( ( board.charAt( 4 ) == c ) && ( board.charAt( 7 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			
			case 2:
				if( ( ( board.charAt( 0 ) == c ) && ( board.charAt( 1 ) == c ) ) || ( ( board.charAt( 14 ) == c ) && ( board.charAt( 23 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
						
			case 3:
				if( ( ( board.charAt( 4 ) == c ) && ( board.charAt( 5 ) == c ) ) || ( ( board.charAt( 10 ) == c ) && ( board.charAt( 18 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}

			
			case 4:
				if( ( ( board.charAt( 3 ) == c ) && ( board.charAt( 5 ) == c ) ) || ( ( board.charAt( 1 ) == c ) && ( board.charAt( 7 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 5:
				if( ( ( board.charAt( 3 ) == c ) && ( board.charAt( 4 ) == c ) ) || ( ( board.charAt( 13 ) == c ) && ( board.charAt( 20 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 6:
				if( ( ( board.charAt( 7 ) == c ) && ( board.charAt( 8 ) == c ) ) || ( ( board.charAt( 11 ) == c ) && ( board.charAt( 15 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 7:
				if( ( ( board.charAt( 6 ) == c ) && ( board.charAt( 8 ) == c ) ) || ( ( board.charAt( 4 ) == c ) && ( board.charAt( 1 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 8:
				if( ( ( board.charAt( 6 ) == c ) && ( board.charAt( 7 ) == c ) ) || ( ( board.charAt( 12 ) == c ) && ( board.charAt( 17 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 9:
				if( ( ( board.charAt( 0 ) == c ) && ( board.charAt( 21 ) == c ) ) || ( ( board.charAt( 10 ) == c ) && ( board.charAt( 11 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 10:
				if( ( ( board.charAt( 9 ) == c ) && ( board.charAt( 11 ) == c ) ) || ( ( board.charAt( 3 ) == c ) && ( board.charAt( 18 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 11:
				if( ( ( board.charAt( 9 ) == c ) && ( board.charAt( 10 ) == c ) ) || ( ( board.charAt( 6 ) == c ) && ( board.charAt( 15 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
				
			case 12:
				if( ( ( board.charAt( 13 ) == c ) && ( board.charAt( 14 ) == c ) ) || ( ( board.charAt( 8 ) == c ) && ( board.charAt( 17 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}		
			
			case 13:
				if( ( ( board.charAt( 12 ) == c ) && ( board.charAt( 14 ) == c ) ) || ( ( board.charAt( 5 ) == c ) && ( board.charAt( 20 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 14:
				if( ( ( board.charAt( 5 ) == c ) && ( board.charAt( 23 ) == c ) ) || ( ( board.charAt( 12 ) == c ) && ( board.charAt( 13 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 15:
				if( ( ( board.charAt( 16 ) == c ) && ( board.charAt( 17 ) == c ) ) || ( ( board.charAt( 6 ) == c ) && ( board.charAt( 11 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}

			
			case 16:
				if( ( ( board.charAt( 15 ) == c ) && ( board.charAt( 17 ) == c ) ) || ( ( board.charAt( 19 ) == c ) && ( board.charAt( 22 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 17:
				if( ( ( board.charAt( 8 ) == c ) && ( board.charAt( 12 ) == c ) ) || ( ( board.charAt( 15 ) == c ) && ( board.charAt( 16 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 18:
				if( ( ( board.charAt( 3 ) == c ) && ( board.charAt( 10 ) == c ) ) || ( ( board.charAt( 19 ) == c ) && ( board.charAt( 20 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 19:
				if( ( ( board.charAt( 18 ) == c ) && ( board.charAt( 20 ) == c ) ) || ( ( board.charAt( 16 ) == c ) && ( board.charAt( 22 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}

			
			case 20:
				if( ( ( board.charAt( 5 ) == c ) && ( board.charAt( 13 ) == c ) ) || ( ( board.charAt( 18 ) == c ) && ( board.charAt( 19 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 21:
				if( ( ( board.charAt( 0 ) == c ) && ( board.charAt( 9 ) == c ) ) || ( ( board.charAt( 22 ) == c ) && ( board.charAt( 23 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 22:
				if( ( ( board.charAt( 21 ) == c ) && ( board.charAt( 23 ) == c ) ) || ( ( board.charAt( 16 ) == c ) && ( board.charAt( 19 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}
			
			case 23:
				if( ( ( board.charAt( 21 ) == c ) && ( board.charAt( 22 ) == c ) ) || ( ( board.charAt( 2 ) == c ) && ( board.charAt( 14 ) == c ) ) ) {
					return true;
				}
				else{
					return false;
				}


		}

		return false;
	}

	
	String pickBoard( LinkedList<String> list, int mode ){ // select the board with highest evaluated score
	
		LinkedList<String> copy = list;
		int old_score = 0;
		int new_score = 0;
		String best = "";
		String board;

		for( int i = 0; i < list.size(); i++ ){
			board = copy.poll();
			best = board;
			if ( mode == 2 ){
				new_score = staticEstimateMidEnd( board );
			}
			else{
				new_score = staticEstimateOpening( board );//estimate opening
			}
			if( new_score > old_score ){
				old_score = new_score;
				best = board;
			}
		}
		System.out.println("Best score:" + old_score );
		return best;
	
	}




	int staticEstimateMidEnd( String board ){ // get the evaluated value in mid or end game
		int numWhite = 0;
		int numBlack = 0;
		int numBlackMoves = numberOfBlackMoves( board, 1 );
		char position;

		for( int i = 0; i < 24; i++ ){
			position = board.charAt( i );
			if ( position == 'W' ){
				numWhite++;
			
			}
			else if( position == 'B' ){
				numBlack++;
			}
		
		}
		
		if( numBlack <= 2 ){
			System.out.println("You lose!!" );
			return( 10000 );
		}
		else if( numWhite <= 2 ){

			return( -10000 );
		}
		else if( numBlackMoves == 0 ){
			return( 1000 ); 
		}
		else{   

			for( int i = 0; i < 24; i++){
				if( closeMill( i, board )){	
					return( 1000*(numWhite - numBlack ) - numBlackMoves + 9000 );		
				}
				else{
					return( 1000*( numWhite - numBlack ) - numBlackMoves );
			
				}
				
				
			}
			return( 1000*( numWhite - numBlack ) - numBlackMoves );
			
		}
	
	}

	int staticEstimateOpening( String board ){ // get the evaluated value of opening
		int numWhite = 0;
		int numBlack = 0;
		char position;

		for( int i = 0; i < 24; i++ ){
			position = board.charAt( i );
			if ( position == 'W' ){
				numWhite++;
			
			}
			else if( position == 'B' ){
				numBlack++;
			}
		
		}
		return 1000*( numWhite - numBlack );
	}





	int numberOfBlackMoves( String board, int mode ){ // get the number of possible black moves
		if( mode == 1 ){
			return generateBlackMovesOpening( board );
		}
		else{
			return generateBlackMovesMidEnd( board );
		}

	
	
	}


	int generateBlackMovesOpening( String board ){ // generate black move in the opening 
		int numBlackMoves = 0;
		char position;
		

		for( int i = 0; i < 24; i ++){
			position = board.charAt( i );
			if( position == 'x' ){

				StringBuilder sb = new StringBuilder( board );
				sb.setCharAt( i, 'B' );
	

				if( closeMill( i, new String( sb ) ) ){
					generateBlackRemove( new String( sb ), numBlackMoves );
					
				}
				else{
					numBlackMoves++;
					
				}
			}
		}
		return numBlackMoves;
		

	}

	int generateBlackRemove( String board, int numBlackMoves ){ // generate remove from black point of view(i.e, remove white)
		char position;
		boolean added = false;
		

		for( int i = 0; i < 24; i++ ){
			position = board.charAt( i );

			if( position == 'W' ){
				if( !closeMill( i, board ) ){
					StringBuilder sb = new StringBuilder( board );
					sb.setCharAt( i, 'x' );
					numBlackMoves++;
					added = true;
				}
			}
		
		}

		if( added == false ){
			numBlackMoves++;
		}
		return numBlackMoves;
	
	}



	int generateBlackMovesMidEnd( String board ){ // generae black moves in mid and end game
		LinkedList<String> list = new LinkedList<String>();
		char position;
		int numWhite = 0;
		
		for( int i = 0; i < 24; i++ ){
			if( board.charAt( i ) == 'W' ){
				numWhite++;
			}
		} 

		if( numWhite == 3 ){
			return generateBlackHopping( board );
		}
		else{
			return generateBlackMoves( board );
		}
		
	
	
	}

	int generateBlackHopping( String board ){ // generate black hopping
		LinkedList<String> list = new LinkedList<String>();
		char position1;
		char position2;
		int numBlackMoves = 0;
		

		for( int i = 0; i < 24; i++){
			position1 = board.charAt( i );
			
			if( position1 == 'B' ){
				for( int j = 0; j < 24; j++ ){
					position2 = board.charAt( j );
					if( position2 == 'x' ){
						
						StringBuilder sb = new StringBuilder( board );
						sb.setCharAt( i, 'x' );
						sb.setCharAt( j, 'B' );
						if( closeMill( j, new String( sb ) ) ){
							generateBlackRemove( board, numBlackMoves );
						}
						else{
							numBlackMoves++;
						
						}
						
						
						
					}
				
					
				
				}
			
			}
		}
		return numBlackMoves;
	}

	int generateBlackMoves( String board){  // generate the black moves 
	LinkedList<String> list = new LinkedList<String>();
		int[] n = new int[4];
		char position;
		boolean added = false;
		int numBlackMoves = 0;

		for( int i = 0; i < 24; i++){
			position = board.charAt( i );
			if( position == 'B' ){
				n = neighbors( i );
				

				for( int j = 0; j < 4; j++ ){
					if( n[ j ] != -1 ){
						if( board.charAt( n[ j ] ) == 'x' ){
							StringBuilder sb = new StringBuilder( board );
							sb.setCharAt( i, 'x' );
							sb.setCharAt( n[ j ], 'B' );
							if( closeMill( n[ j ], new String( sb ) ) ){
								generateBlackRemove( new String( sb ), numBlackMoves );
							}
							else{
								numBlackMoves++;
							}
						}


					}
				}
				
			
			}
		
		}
	
		return numBlackMoves;

	
	}







}


