
(function($) {
  // 'use strict';

  $(function() {
    // validate the comment form when it is submitted
    $("#commentForm").validate({
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });
    
    // validate signin form on keyup and submit
    $("#login-form").validate({
      rules: {
        userid: {
          required: true,
         },
        passwd: {
          required: true
        }
      },
      messages: {
        userid: {
          required: "아이디를 입력해주세요"
        },
        passwd: {
          required: "비밀번호를 입력해주세요"
        }
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });    

    $("#register-form").validate({
      onkeyup: function(element) {
        $(element).valid(); 
      },
      rules: {
        userid: {
          required: true,
          remote : {
            type: 'post',
            url : '/signup/idDupCheck',
            data: {
              userid: function() {
                return $( "#userid" ).val();
              }
            }
            // ,
            // success : function(ret){
            //   console.log("return : "+ ret);
            //   if(ret == true){
            //     console.log("중복.... ");
            //     return ret;
            //   }
            // }
          } 
         },
        username: {
          required: true,
          minlength: 2
        },
        passwd: {
          required: true,
          minlength: 4
        },
        re_passwd: {
          required: true,
          minlength: 4,
          equalTo: "#passwd"
        },
        email: {
          required: true,
          email: true
        },
        topic: {
          required: "#newsletter:checked",
          minlength: 2
        },
        agree: "required"
      },
      messages: {
        userid: {
          required: "아이디를 입력해주세요",
          remote: "이미 사용중인 아이디 입니다"
        },
        username: {
          required: "이름을 입력해주세요",
          minlength: "이름은 최소 2글자로 입력해주세요"
        },
        passwd: {
          required: "비밀번호를 입력해주세요",
          minlength: "비밀번호는 최소 4자리로 입력해주세요"
        },
        re_passwd: {
          required: "비밀번호를 확인해주세요",
          minlength: "비밀번호는 최소 4자리로 입력해주세요",
          equalTo: "비밀번호가 일치하지 않습니다"
        },
        email: {
          required: "이메일을 입력해주세요",
          email: "유효한 이메일이 아닙니다"
        },
        agree: "Please accept our policy",
        topic: "Please select at least 2 topics"
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });

    $("#user-form").validate({
      onkeyup: function(element) {
        $(element).valid(); 
      },
      rules: {
        username: {
          required: true,
          minlength: 2
        },
        before_passwd: {
          required: true,
          remote : {
            type: 'post',
            url : '/user/passwdChk',
            data: {
              before_passwd: function() {
                return $( "#before_passwd" ).val();
              }
            }
          } 
        },
        passwd: {
          required: true,
          minlength: 4
        },
        re_passwd: {
          required: true,
          minlength: 4,
          equalTo: "#passwd"
        },
        email: {
          required: true,
          email: true
        }
      },
      messages: {
        username: {
          required: "이름을 입력해주세요",
          minlength: "이름은 최소 2글자로 입력해주세요"
        },
        before_passwd:{
          required: "비밀번호 입력해주세요",
          remote:"비밀번호가 올바르지 않습니다"
        },
        passwd: {
          required: "새 비밀번호를 입력해주세요",
          minlength: "비밀번호는 최소 4자리로 입력해주세요"
        },
        re_passwd: {
          required: "비밀번호를 확인해주세요",
          minlength: "비밀번호는 최소 4자리로 입력해주세요",
          equalTo: "비밀번호가 일치하지 않습니다"
        },
        email: {
          required: "이메일을 입력해주세요",
          email: "유효한 이메일이 아닙니다"
        },
        
      },
      errorPlacement: function(label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
      },
      highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
      }
    });



    //code to hide topic selection, disable for demo
    var newsletter = $("#newsletter");
    // newsletter topics are optional, hide at first
    var inital = newsletter.is(":checked");
    var topics = $("#newsletter_topics")[inital ? "removeClass" : "addClass"]("gray");
    var topicInputs = topics.find("input").attr("disabled", !inital);
    // show when newsletter is checked
    newsletter.on("click", function() {
      topics[this.checked ? "removeClass" : "addClass"]("gray");
      topicInputs.attr("disabled", !this.checked);
    });


    $.extend($.validator.messages, {
      required: "필수 항목입니다.",
      remote: "이미 사용중인 아이디입니다",
      email: "유효하지 않은 e-mail주소입니다.",
      url: "유효하지 않은 URL입니다.",
      date: "올바른 날짜를 입력하세요.",
      dateISO: "올바른 날짜(ISO)를 입력하세요.",
      number: "유효한 숫자가 아닙니다.",
      digits: "숫자만 입력 가능합니다.",
      creditcard: "신용카드 번호가 바르지 않습니다.",
      equalTo: "같은 값을 다시 입력하세요.",
      extension: "올바른 확장자가 아닙니다.",
      maxlength: $.validator.format("{0}자를 넘을 수 없습니다. "),
      minlength: $.validator.format("{0}자 이상 입력하세요."),
      rangelength: $.validator.format("문자 길이가 {0} 에서 {1} 사이의 값을 입력하세요."),
      range: $.validator.format("{0} 에서 {1} 사이의 값을 입력하세요."),
      max: $.validator.format("{0} 이하의 값을 입력하세요."),
      min: $.validator.format("{0} 이상의 값을 입력하세요.")
    });

  });


})(jQuery);