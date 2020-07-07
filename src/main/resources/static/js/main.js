var main = {};
main.fn = {};

var contextPath = "http://localhost:8080";

main.services = {
    getCategories: {
        URL: contextPath + '/category/all'
    },
    updatePassword: {
        URL: contextPath + '/user/updatePassword',
        PARAMETERS: {
            USERNAME: "?USERNAME=",
            O_PASSWORD: "&O_PASSWORD=",
            N_PASSWORD: "&N_PASSWORD="
        }
    }
};

main.fn.ajax = function (type, url, data, success) {
    $.ajax({
        type: type,
        url: url,
        data: data,
        success: success,
        dataType: 'json',
        error: function(xhr, desc, err) {
            console.log(xhr);
            console.log("Details : " + desc + "\nError:" + err);
        },
    });
};

main.fn.ajaxGet = function(url, success){
    main.fn.ajax('GET', url, null, success);
}

main.fn.ajaxPost = function(url, success){
    main.fn.ajax('POST', url, null, success);
}

main.fn.ajaxPostwData = function(url, data, success){
    main.fn.ajax('POST', url, data, success);
}

main.fn.getAllCategories = function () {
    main.fn.ajaxGet(main.services.getCategories.URL, function (result) {
        var $categoryDropdown = $("#categoryList");
        $categoryDropdown.empty();

        $.each(result.data, function(i, category){
            $categoryDropdown.append($("<a>"+category.name+"</a>")
                .attr("class","dropdown-item")
                .attr("href",contextPath + "/category/" + category.id));
        });

    });
}

main.fn.updatePassword = function(){
    var url = main.services.updatePassword.URL;

    var username = $("#username").val();
    var oldPassword = $("#old-password").val();
    var newPassword = $("#new-password").val();
    var newPasswordAgain = $("#new-password-again").val();

    if(newPassword == newPasswordAgain){
        url += main.services.updatePassword.PARAMETERS.USERNAME + username;
        url += main.services.updatePassword.PARAMETERS.O_PASSWORD + oldPassword;
        url += main.services.updatePassword.PARAMETERS.N_PASSWORD + newPassword;

      main.fn.ajaxGet(url, function (result) {
          console.log(result.message);
          $("#updatePasswordModal").modal('hide');
      })
    }
}

main.fn.startPage = function (){
    // Get Category List for Navbar
    main.fn.getAllCategories();
}

// Update user password
$('#btn-update-password').click(function () {
    main.fn.updatePassword();
});

$(document).ready(function () {
     main.fn.startPage();
});
