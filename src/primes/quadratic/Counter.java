package primes.quadratic ;

import java.math.BigInteger ;

//import primes.erathostenes.Token;
public class Counter extends primes.Counter<Token> {
private	BigInteger factoring ; 
private BigInteger root ;

public Counter() {
		super(new Token());
	}

BigInteger squareroot ( BigInteger x) {
	return x.divide(new BigInteger("2")) ;
	
}

public Counter(BigInteger f) {
	// TODO Auto-generated constructor stub
	this();
	this.factoring = f ;
	this.root = squareroot(f) ;
	
}

BigInteger factoring() {
	return this.factoring;
	
}


public 	Token token() {
	return super.token();
}


public Token get() {
	if (this.token().primality())
		  {
			this.token().Reset(this.value(), this.value());
			this.set() ;
		  }
	else
		{
			BigInteger tmp =  this.setroot();
			this.token().Reset(this.root, tmp );
			
		};
		
		return this.token() ;
}

BigInteger setroot() {
	this.root = this.root.add(BigInteger.ONE);
	return this.root.multiply(this.root).mod(this.factoring);
	
}


}
