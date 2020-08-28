<template>
    <div id="register-box">
        <b-container class="text-center">
            <h3>Register</h3>
            <br>
            <div role="group">
                <div>
                    <label for="input-live" class="mt-1"><b>Username:</b></label>
                    <b-form-input
                            id="input-live"
                            v-model="username"
                            :state="usernametest"
                            aria-describedby="input-live-help input-live-feedback"
                            placeholder="Enter your name"
                            trim
                            @change="checkUsername"
                    ></b-form-input>
                    <b-form-invalid-feedback id="input-live-feedback">
                        Username is taken
                    </b-form-invalid-feedback>
                </div>

                <div>
                    <label for="input-live" class="mt-2"><b>Name:</b></label>
                    <b-form-input
                            id="input-live"
                            v-model="firstName"
                            :state="nameState"
                            aria-describedby="input-live-help input-live-feedback"
                            placeholder="Enter your First Name"
                            trim
                    ></b-form-input>
                    <!-- This will only be shown if the preceding input has an invalid state -->
                    <b-form-invalid-feedback id="input-live-feedback">
                        Enter at least 3 letters
                    </b-form-invalid-feedback>
                </div>

                <div>
                    <label for="input-live" class="mt-2"><b>lastName:</b></label>
                    <b-form-input
                            id="input-live"
                            v-model="lastName"
                            :state="lastNameState"
                            aria-describedby="input-live-help input-live-feedback"
                            placeholder="Enter your Last Name"
                            trim
                    ></b-form-input>
                    <b-form-invalid-feedback id="input-live-feedback">
                        Enter at least 3 letters
                    </b-form-invalid-feedback>
                </div>

                <label for="input-live" class="mt-2"><b>Password:</b></label>
                <b-form-input
                        id="input-live"
                        type="password"
                        v-model="password"
                        aria-describedby="input-live-help input-live-feedback"
                        placeholder="Password"
                        trim
                ></b-form-input>

                <label for="input-live" class="mt-2"><b>Confirm your password:</b></label>
                <b-form-input
                        id="input-live"
                        type="password"
                        v-model="repeatedPassword"
                        aria-describedby="input-live-help input-live-feedback"
                        placeholder="Confirm your password."
                        trim
                ></b-form-input>
                <b-button variant="primary" class="mt-3 mb-2" @click="getShit">Sign-up</b-button>
                <div>
                    <b-list horizontal="md">
                        <b-list-item><h6 class="mb-1">Have an account?</h6></b-list-item>
                        <b-list-item>
                            <b-link href="#foo">Sign in!</b-link>
                        </b-list-item>
                    </b-list>
                </div>
            </div>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: "RegisterForm",
        data() {
            return {
                username: '',
                firstName: '',
                lastName: '',
                password: '',
                repeatedPassword: '',
                usernametest: false

            }
        }, computed: {
            nameState() {
                return this.firstName.length > 2 ? true : false
            }, lastNameState() {
                return this.lastName.length > 2 ? true : false
            },
            checkPassword() {
                return true;
                //todo
            }
        },
        methods : {
            getShit() {
                fetch("http://localhost:8081/auth/check-username/mamad")
                    .then(response => response.json())
                    .then(response => console.log(response));
            },
            checkUsername() {
                console.log(12);
                fetch(`http://localhost:8081/auth/check-username/${this.username}`)
                    .then(response => response.json())
                    .then(response => this.usernametest = response);
            }
        }
    }

</script>

<style scoped>
    .text-center {
        margin-top: 3%;
        width: 300px;
    }
</style>