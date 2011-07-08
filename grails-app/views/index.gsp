<html>
    <head>
        <title>Welcome to Grails Calendar</title>
        <meta name="layout" content="main" />
        <style type="text/css" media="screen">
        #pageBody {
            margin-left:280px;
            margin-right:20px;
            font-size: 18px;
        }
        </style>
    </head>
    <div id='who' style='position:absolute; top: 8px; right: 100px;font-size: 14px;'><sec:ifLoggedIn><sec:loggedInUserInfo field="username"/> | <a href="${createLink(controller:'logout')}">logout</a></sec:ifLoggedIn><sec:ifNotLoggedIn><a href="${createLink(controller:'register')}">register</a> or <a href="${createLink(controller:'login')}">login</a></sec:ifNotLoggedIn></div> 
    <div id="pageBody">
        <p>This is a proof of concept to use the grails Events-Calendar plugin</p>
        you can find the plugin available on <a href="https://github.com/fix/grails-events-calendar">GitHub</a> as well as the source of <a href="https://github.com/fix/Calendar">this application</a>
        <br/><br/>
        	You need first to <a href="${createLink(controller:'register')}">register</a> or <a href="${createLink(controller:'login')}">login</a>
        <br/><br/>
        Then you can access the list of created calendars <a href="${createLink(controller:'calendar', action:'list')}">here</a>
        <br/>
        TIP: Try drag&drop on calendar to create or update events on different views (month, week, day)
        </div>
        
        
    </body>
</html>
