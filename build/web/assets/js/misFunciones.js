  
function positionSuccess(position) {
    
    $("#la").val(position.coords.latitude)
    $("#lo").val(position.coords.longitude)
    
    var iframe = ""+
            "<center>"+
                "<iframe class='iframe' src='https://maps.google.com/?q="+position.coords.latitude+","+position.coords.longitude+"&z=18&t=m&output=embed' width='400' height='300' frameborder='0' allowfullscreen>"+

                "</iframe>"+
            "</center>";
    document.getElementById("mapa").innerHTML = iframe;
    console.log(position);
}

function positionError(error) {
    alert('ERROR');
    switch (error.code) {
        case error.PERMISSION_DENIED:
            document.getElementById('theError').innerHTML = "User denied the request for Geolocation."
            break;
        case error.POSITION_UNAVAILABLE:
            document.getElementById('theError').innerHTML = "Location information is unavailable."
            break;
        case error.TIMEOUT:
            document.getElementById('theError').innerHTML = "The request to get user location timed out."
            break;
        case error.UNKNOWN_ERROR:
            document.getElementById('theError').innerHTML = "An unknown error occurred."
            break;
    }
}
window.onload = () => {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(positionSuccess, positionError);
    } else {
        alert('Browser do not support Geoloation');
    }
};