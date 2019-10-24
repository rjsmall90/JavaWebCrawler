# Simple JavaWebCrawler
I have an app idea that involves a the usage of a web crawler and wanted to build one in Java to see how it functions. 

Using Java, Maven, & JSoup - Built a simple Java Web Crawler that targets a specific url
and with a given keyword will locate the links on website that contains keyword and compile them into a list.

## How To Use
• Functions by calling Spider.search(url, searchWord). Returns true if searchWord found. 

• Then compiles a list of links that are accessible by calling SpiderLeg.getLinks(); 

## What I Learned
On my previous Macbook it took a few days to build seeing as it was very old and ran incredibly slow. 

By building this I learned more about Error Handling and accessing outside Java libraries by importing maven dependencies.
It also helped improved my understanding of application architecture and design patterns. 
This crawler was simple in the sense that it returned a boolean based on if the word was found rather than the links. 
What I want from my specific crawler is the ability to not only target the links but print those to a console or separate text file.
Will improve on Simple JWC to fit the specifications necessary for my future application. 


 
