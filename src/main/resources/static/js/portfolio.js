$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/portfolio/3"
    }).then(function (data) {
        $('.fullname').append(data.title);
        $('.name').append(data.name);
        $('.description').append(data.description);
        $('.imageProfile').attr("src", data.imageUrl);

        for (var i = 0; i < data.tweets.length; i++) {
            $('.tweets').append("<div>" +
                    "<strong><img class=\"img-size-32 img-fluid img-circle imageProfile\"  src=\""+ data.tweets[i].image +" \" ></i>" +
                    data.tweets[i].name + "</strong>" +
                    "<p class=\"text-muted\">" +
                    data.tweets[i].message +
                    "</p>" +
                    "<hr>" +
                    "</div>");
        }


    });
});