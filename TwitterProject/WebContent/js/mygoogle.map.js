/**
 * This is customized javascript file to use google map api soomthly for Twitter
 * Project
 */

function initMap() {

	var pos = {
		lng : -91.966760,
		lat : 41.018132
	};
	var map = new google.maps.Map(document.getElementById('map'), {
		center : pos,
		zoom : 6
	});

	var infowindow = new google.maps.InfoWindow();
	var marker = new google.maps.Marker();

	var markers = [];

	function processOnPosition(position) {
		pos = {
			lat : position.coords.latitude,
			lng : position.coords.longitude
		};
		// console.log(pos);
	}

	// show on load first marker
	placeMarker(pos);

	// Sets the map on all markers in the array.

	map.setCenter(pos);

	marker.addListener('click', function() {
		infowindow.open(map, marker);
	});

	// This event listener will call addMarker() when
	// the map is clicked.
	google.maps.event.addListener(map, 'click', function(event) {
		clearMarkers();
		// console.log("LAT == "+event.latLng.lat);
		placeMarker(event.latLng);
	});

	function placeMarker(location) {
		marker.setPosition(location);
		marker.setMap(map);
		markers.push(marker);
		showInfo(location);
	}

	function setMapOnAll(map) {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(map);
		}
	}

	function clearMarkers() {
		setMapOnAll(null);
	}

	function showInfo(pos) {
		ajaxGetTrends(pos.lat, pos.lng);
	}

	function displayTrends(json) {
		console.log(json);

		var contentWindow = $("<ul>", {
			"class" : "infoPopup"
		});
		// console.log(contentWindow);
		$.each(json, function(i, trend) {
			contentWindow.append($("<li>").append($("<a>", {
				"href" : trend.url,
				"title" : trend.name,
				"text" : trend.name,
				"target" : "_blank"
			})));
		});
		contentWindow = $("<div>", {
			"class" : "infoPopup"
		}).append(contentWindow);

		// at the end show info box on map
		infowindow.setContent(contentWindow.html());
		infowindow.setPosition(pos);
		infowindow.open(map, marker);
	}

	// ajax for closest trends
	function ajaxGetTrends(lat, lng) {
		$.ajax("googleMapServlet.ajax", {
			"type" : "get",
			"data" : {
				"lat" : lat,
				"lng" : lng
			}
		}).done(displayTrends).fail(ajaxFailure);
	}

	// Try HTML5 geolocation.
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(processOnPosition);
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false, infoWindow, map.getCenter());
	}
}

function handleLocationError(browserHasGeolocation, pos) {
	console.log(browserHasGeolocation + " ; " + pos);
}