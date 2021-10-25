# 2.semScopeDemoSession

### App ...
<li> shows global page counter <br>
<li> Eshop basket is handled with session, i.e. NOT shared among clients/browsers
<li> is dynamic, as it has HTML Form to enter data and send to endpoint in @Controller (WebRequest)
<li> uses Thymeleaf to render data in HTML page which uses thymelaf if and each (loop) operators.
<li> @controller uses redirect
  
 ## Forward vs Redirect
 ### Forward:

<li>The request will be further processed on the server side
<li>The client isn't impacted by forward, URL in a browser stays the same
<li>Request and response objects will remain the same object after forwarding. Request-scope objects will be still available
  
 ### Redirect:

<li> The request is redirected to a different resource
<li> The client will see the URL change after the redirect
<li> A new request is created
<li> Redirect is normally used within Post/Redirect/Get web development pattern
