package primes.quadratic ;
import java.math.BigInteger;

import primes.Item;
//import primes.Bidimensional ;
//import primes.erathostenes.Token;
public class Sieve extends primes.Sieve<Token> {
 BigInteger factoring ;

/**
 * In the extension of a class constructors arenot inherited
 */
public	Sieve (String[] args) {
		super(args, new Counter(new BigInteger(args[1]) )) ;
		this.factoring = ((Counter)this.next()).factoring();
		System.out.println("constructing quadratic Sieve");
	
		this.mainloop();
		this.print() ;
	}

	

	
public	boolean testloop(Token token) {
	System.out.println("token in testloop:\n residue :"+token.value()+" intero: "+token.value2());
	
	return ( token.value2().compareTo(this.getmax()) != 1) ;
}
	
	
/**
 * @override of the erathosenes.Sieve mainloop
 * the only difference is on the test of
 * the primality boolean in order to create a new Filter objet
 */
	public void mainloop() {
		Token token ;
		
		
		token.SetPrimality(false);
		token = (Token) this.next().get() ;
		System.out.println("in Q:S:mailoop before while "+token.value2());
		// testloop nel caso di primality false controlla se il residuo del token e' 1
		//  se non e' uno allora genero nuovi filtri = set primality a true 
//while rango della matrice minore numero di righe		
		
		//se il residuo del token = 1 allora aggiungo la riga 
		// e faccio un nuovo get (sempre con primality a false)
		
		// altrimenti se il residuo del token non e' 1
			// setprimality(true)
		

		while (testloop(token)) {
			if (token.primality()) {
				this.seteuler() ;
				this.set( new Filter(this.next() , token.value() ));
			}
			else 
			{
				// creare oggetto ROW che memorizza il candidato
				
			};
			
			
			System.out.println("in Q:S:mailoop after while : ready to new S:get()");
			token = this.next().get() ;
			
			System.out.println("in Q:S:mailoop new integer : "+token.value2()+" "+token.value());
		};
		
	}
	
	public void printmatrix() {
		/* bisogna essere sicuri che si ha un Filter o un Matrix */
		((Filter)this.next()).column().print() ;
		
	}

	public Token get() {
		return null ;
	}

}
