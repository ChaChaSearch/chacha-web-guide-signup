<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title>Guide Signup Input Form</title>
		<link href="<c:url value='/static/css/signup.css'/>" rel="stylesheet" media="screen"/>
	</head>
	<body>
		<div class="intro">
			Please Input the following fields.  All fields but Middle Initial are required.
		</div>
		<div class="input-body">
			<form method="POST" action="<c:url value='/signup/completeform'/>" id="input-form">
				<!-- Name -->
				<div class="input-section">
					<p class="input-row">
						<label for="first-name">First Name</label>
						<input id="first-name" type="text" name="firstName"/>
					</p>
					
					<p class="input-row">
						<label for="middle-initial">Middle Initial</label>
						<input id="middle-initial" type="text" name="middleInitial"/>
						<span id="middle-initial-error" class="error hidden">Middle Initial must be single letter</span>
					</p>
					
					<p class="input-row">
						<label for="last-name">Last Name</label>
						<input id="last-name" type="text" name="lastName"/>
					</p>
				</div>
				
				<!-- Login information -->
				<div class="input-section">
					<p class="input-row">
						<label for="email">Email Address</label>
						<input id="email" type="text" name="email"/>
						<span id="email-error" class="error hidden">Email Address must be unique and valid</span>
					</p>
					
					<p class="input-row">
						<label for="handle">Handle</label>
						<input id="handle" type="text" name="handle"/>
						<span id="handle-error" class="error hidden">Handle is already taken</span>
					</p>
					
					<p class="input-row">
						<label for="password">Password</label>
						<input id="password" type="password" name="password"/>
						<span id="password-error" class="error hidden">Passwords must match</span>
					</p>
					
					<p class="input-row">
						<label for="password-match">Repeat Password</label>
						<input id="password-match" type="password"/>
					</p>
				</div>
				
				
				<!-- Personal Information -->
				<div class="input-section">
					<p class="input-row">
						<label for="gender">Gender</label>
						<select id="gender" name="gender">
							<option value="FEMALE">Female</option>
							<option value="MALE">Male</option>
						</select>
					</p>
					
					<p class="input-row">
						<label for="birthdate">Date of Birth</label>
						<input id="birthdate" type="text" name="birthdate"/>
						<span id="birthdate-error" class="error hidden">Please format as such: MM/DD/YYYY</span>
					</p>
					
					<p class="input-row">
						<label for="government-id-type">Government Identification</label>
						<select id="government-id-type" name="governmentIdType">
							<option value="SSN">Social Security Number</option>
							<option value="EIN">Employer Identification Number</option>
						</select><br/>
						<input id="government-id" type="text" name="governmentId"/>
						<span id="government-id-error" class="error hidden">Bad Id. This should be overwritten by script</span>
					</p>
				</div>
				
				<!-- Contact Information -->
				<div class="input-section">
					<p class="input-row">
						<label for="address1">Address</label>
						<input id="address1" type="text" name="address1"/><br/>
						<input id="address2" type="text" name="address2"/>
					</p>
					
					<p class="input-row">
						<label for="city">City</label>
						<input id="city" type="text" name="city"/>
					</p>
					
					<p class="input-row">
						<label for="state">State</label>
						<select id="state" name="state">
							<option value="*">Select One</option>
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WY">Wyoming></option>
						</select>
					</p>
					
					<p class="input-row">
						<label for="postal-code">Postal Code</label>
						<input id="postal-code" type="text" name="postalCode"/>
						<span id="postal-code-error" class="error hidden">Postal code appears to be invalid</span>
					</p>
					
					<p class="input-row">
						<label for="phone">Phone Number</label>
						<input id="phone" type="text" name="phone"/>
						<span id="phone-error" class="error hidden">Phone number appears to be invalid</span>
					</p>
				</div>
				
				<button id="submit-button" type="button" disabled="true">Submit</button>
				<div id="required-fields-error" class="error">You have not filled in all of the required fields</div>
			</form>
		</div>
	</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
		$().ready(function() {
			
			$("input,select").change(function() {
				var isValid = validate();
				$('#submit-button').prop('disabled', !isValid);
			});
			
			$("#submit-button").click(function() {
				$("#input-form").submit();
			});
		});
		
		
		function validate() {
			var isValid = validateRequiredFields()
							&& validateMiddleInit()
							&& validateEmail()
							&& validateHandle()
							&& validateSSN()
							&& validateEIN()
							&& validatePassword()
							&& validateBirthDate()
							&& validatePostalCode()
							&& validatePhoneNumber();
			
			return isValid;
		}
		
		function validateRequiredFields() {
			var requiredFields = ["#first-name", "#last-name",
			                      "#email", "#handle", "#password",
			                      "#birthdate", "#government-id",
			                      "#address1", "#city", "#postal-code", "#phone"];
			
			var isValid = true;
			for(var i = 0; i < requiredFields.length; i++) {
				var fieldVal = $(requiredFields[i]).val();
				if(fieldVal == 'undefined' || fieldVal == '') {
					isValid = false;
					break;
				}
			}
			
			/* state has its own fun */
			isValid = isValid && $("#state").val() != "*";
			
			if(isValid) {
				$("#required-fields-error").addClass("hidden");
			} else {
				$("#required-fields-error").removeClass("hidden");
			}
			
			return isValid
		}
		
		function validateMiddleInit() {
			var middleInit = $("#middle-initial").val();
			var isValid = middleInit.length <= 1;
			
			if(isValid) {
				$("#middle-initial-error").addClass("hidden");
			} else {
				$("#middle-initial-error").removeClass("hidden");
			}
			
			return isValid
		}
		
		function validateEmail() {
			var email = $("#email").val();
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			var isValid = re.test(email);	
			
			if(isValid) {
				$.ajax({
					url: "<c:url value='/validation/email'/>",
					method: "POST",
					data: {"value":email},
					async: false
				}).success(function(data) {
					if(data == "true") {
						$("#email-error").addClass("hidden");
					} else if(data == "false") {
						$("#email-error").removeClass("hidden");
						isValid = false;
					}
				});
			}
			
			return isValid;
		}
		
		function validateHandle() {
			var handle = $("#handle").val();
			var isValid = false;
			
			$.ajax({
				url: "<c:url value='/validation/handle'/>",
				method: "POST",
				data: {"value":handle},
				async: false
			}).success(function(data) {
				if(data == "true") {
					isValid = true;
					$("#handle-error").addClass("hidden");
				} else if(data == "false") {
					$("#handle-error").removeClass("hidden");
				}
			});
			
			return isValid;
		}
		
		function validatePassword() {
			var isValid = $("#password").val() == $("#password-match").val();
			
			if(isValid) {
				$("#password-error").addClass("hidden");
			} else {
				$("#password-error").removeClass("hidden");
			}
			
			return isValid;
		}
		
		function validateSSN() {
			if($("#government-id-type").val() != 'SSN') {
				return true;
			}
			
			var ssn = $("#government-id").val();
			var re = /^[0-9]{3}-?[0-9]{2}-?[0-9]{4}$/i;
			var isValid = re.test(ssn);	
			
			if(isValid) {
				$.ajax({
					url: "<c:url value='/validation/ssn'/>",
					method: "POST",
					data: {"value":ssn},
					async: false
				}).success(function(data) {
					if(data == "true") {
						$("#government-id-error").addClass("hidden");
					} else if(data == "false") {
						isValid = false;
						$("#government-id-error").removeClass("hidden");
						$("#government-id-error").text("Social Security Number must be valid and unique. Format: XXX-XX-XXXX");
					}
				});
			} else {
				$("#government-id-error").removeClass("hidden");
				$("#government-id-error").text("Social Security Number must be valid and unique. Format: XXX-XX-XXXX");
			}
			
			return isValid;
		}
		
		function validateEIN() {
			if($("#government-id-type").val() != 'EIN') {
				return true;
			}
			
			var ein = $("#government-id").val();
			var re = /^[0-9]{2}-?[0-9]{7}$/i;
			var isValid = re.test(ein);	
			
			if(isValid) {
				$.ajax({
					url: "<c:url value='/validation/ein'/>",
					method: "POST",
					data: {"value":ein},
					async: false
				}).success(function(data) {
					if(data == "true") {
						$("#government-id-error").addClass("hidden");
					} else if(data == "false") {
						isValid = false;
						$("#government-id-error").removeClass("hidden");
						$("#government-id-error").text("Employment Identification Number must be valid and unique. Format: XX-XXXXXXX");
					}
				});
			} else {
				$("#government-id-error").removeClass("hidden");
				$("#government-id-error").text("Employment Identification Number must be valid and unique. Format: XX-XXXXXXX");
			}
			
			return isValid;
		}
		
		function validateBirthDate() {
			var birthDate = $("#birthdate").val();
			var re = /^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/i;
			var isValid = re.test(birthDate);	
			
			if(isValid) {
				$("#birthdate-error").addClass("hidden");
			} else {
				$("#birthdate-error").removeClass("hidden");
			}
			
			return isValid;
		}
		
		function validatePostalCode() {
			/* only supporting us zip codes right now */
			var zipCode = $("#postal-code").val();
			var re = /^[0-9]{5}(-[0-9]{4})?$/i;
			var isValid = re.test(zipCode);	
			
			if(isValid) {
				$("#postal-code-error").addClass("hidden");
			} else {
				$("#postal-code-error").removeClass("hidden");
			}
			
			return isValid;
		}
		
		function validatePhoneNumber() {
			/* only supporting us zip codes right now */
			var phoneNumber = $("#phone").val();
			var re = /^\(?[0-9]{3}\)?-?[0-9]{3}-?[0-9]{4}$/i;
			var isValid = re.test(phoneNumber);	
			
			if(isValid) {
				$("#phone-error").addClass("hidden");
			} else {
				$("#phone-error").removeClass("hidden");
			}
			
			return isValid;
		}
	</script>
</html>

