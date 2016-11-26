$(function() {// window.onload
	$("a.query").click(getTwitterData);// .trigger('click');

	$('.loader').hide() // Hide it initially
	.ajaxStart(function() {
		$(this).show();
	}).ajaxStop(function() {
		$(this).hide();
	});

	// responsive top menu
	$("html").click(function(e) {
		$("#myTopnav").removeClass("responsive");
	});

	$("#menuIcon").click(function(e) {
		e.stopPropagation();// stop propagation here... becoz this button is inside html, body, div ... elements
		if (!$("#myTopnav").hasClass("responsive")) {
			$("#myTopnav").addClass("responsive");
		} else {
			$("#myTopnav").removeClass("responsive");
		}
	});
});

// Creating Tweet box using jquery .... :: Revealing Module Pattern
var createTweetDOM = function(user) {
	// this variable is private
	var myDom = $("<div>", {
		"class" : "tweet"
	}).append($("<div>", {
		"class" : "user"
	}).append($("<img>", {
		"src" : user.userImage,
		"title" : user.userName,
		"alt" : user.userName
	})).append($("<span>", {
		"text" : user.userName
	}))).append($("<div>", {
		"class" : "user-text"
	}).append($("<a>", {
		"text" : user.userText,
		"href" : "https://www.twitter.com/" + user.userId,
		"title" : user.userName,
		"target" : "_blank"
	})));

	function getDOM() {// public
		return myDom;
	}

	return {
		"getDOM" : getDOM
	}
}

// get tweets from servlet(calls API)
function getTwitterData() {
	if (!$.cookie("query")) {
		$.cookie("query", "documentry");
	} else {
		$.cookie("query", $(this).attr("id"));
	}

	console.log("I clicked on: " + $.cookie("query"));
	
	$.ajax("twitterServlet.ajax", {
		"type" : "get",
		"data" : {
			"query" : $.cookie("query")
		}
	}).done(dispalyTweets).fail(ajaxFailure);
}

// Display tweets coming from API call
function dispalyTweets(json) {
	console.log(json);
	var data = $("#query-data").empty();
	var resDom;
	$.each(json, function(i, user) {
		// resDom = createTweetDOM(user);
		data.append(createTweetDOM(user).getDOM);
	});
	activateTweetMenu();//set activate to current clicked menu (Documentary, action, ...)
}

/* If Ajax failed call this method... */
function ajaxFailure(xhr, status, exception) {
	console.log(xhr, status, exception);
}

function activateTweetMenu() {
	$(".query").removeClass("active");
	$("#" + $.cookie("query")).addClass("active");
}
