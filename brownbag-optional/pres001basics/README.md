# Java 8 Optional

https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html

A container object which may or may not contain a non-null value.
If a value is present, isPresent() will return true and get() will return the value.
Additional methods that depend on the presence or absence of a contained value are provided,
such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).


#### Side note on Null
First in ALGOL by Tony Hoare. Cause: It was easy to implement.

 
#### How to create an Optional

1) empty()  // API NOTE   Though it may be tempting to do so, avoid testing if an object is empty by comparing with == against instances returned by Option.empty(). There is no guarantee that it is a singleton. Instead, use isPresent().
2) of()    // No Public constructor
3) ofNullable()

#### Basic instance method

1) isPresent
1) get         // NOTE: If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException.
1) ifPresent   Consumer<? super T> consumer
1) orElse    
1) orElseGet   Supplier<? extends T> other
1) orElseThrow Supplier<? extends X> exceptionSupplier

#### Fluent

1) filter      Predicate<? super T> predicate
1) map         Function<? super T,? extends U> mapper
1) flatMap     Function<? super T,Optional<U>> mapper


##Basic Examples

####Videos
* https://www.youtube.com/watch?v=Ej0sss6cq14&list=PL0biJS0qSvUmUMD-qz1dnBpLvnfrMD7h_

      Optional is intended to provide limited mechanism for library method 
      return types where there is a clear need to represet "no value" and 
      where using null for that is overwhelming and couse errors.
      
      # Rule1
      Never, ever use null for an optional variable or return value
      # Rule2
      Never use Optional.get() unless you can prove that optional is present
      # Rule3
      Prefer alternatives to isPresent get
      # Rule4
      It's generaly bad idea to create an Optional for specific purpose of chaining methods from it to get a value
      #Rule5
      If an Optional chain has a nested Optional chain, or has an intermediate result of Optional<Optional<T>> it's probably to complex
      # Rule6
      Avoid using Optional in fields, method parameters, and collections
      # Rule7
      Avoid using identity-sensitive operations on Optionals
      
      * Optional is not replace for null
      * Optional is a box consumes 16 bytes
     
     

####Posts
https://codecouple.pl/2016/03/09/pozbadz-sie-null-pointerow-java-util-optional/
http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
https://www.slideshare.net/mariofusco/monadic-java


####Books
https://www.manning.com/books/java-8-in-action


#### Groovy

    String version = computer?.getSoundcard()?.getUSB()?.getVersion();
    // Elvis operator
    String version = computer?.getSoundcard()?.getUSB()?.getVersion() ?: "UNKNOWN";

### Purpose 

It is important to note that the intention of the Optional class is not to replace every single null reference.
Instead, its purpose is to help design more-comprehensible APIs so that by just reading the signature of a method, you can tell whether you can expect an optional value.
This forces you to actively unwrap an Optional to deal with the absence of a value.

You no longer need to do an explicit null check; it is enforced by the type system.
    Note Explicite Implicite
    
Stuart Marks




### Java 9 comming methods

* Optional.stream
* Optional.ifPresentOrElse
* Optional.or

###Another containers

#####Java 8
 
* Stream
* CompletableFuture

#####Well known and documented container from Functional Programing

* Promise
* Validation
* Try
* DI
* Reader
* Writer
* Transaction
* State

