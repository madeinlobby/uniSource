<template>
    <div>
        <b-navbar toggleable="sm" type="dark" variant="dark">
            <b-navbar-brand to="/">Sharif Source</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item v-show="!isUserLoggedIn" to="/login">Login</b-nav-item>
                    <b-nav-item v-show="!isUserLoggedIn" to="sign-up">Register</b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav v-show="isUserLoggedIn" class="ml-auto">
                    <b-nav-item-dropdown right>
                        <!-- Using 'button-content' slot -->
                        <template v-slot:button-content>
                            <em>User</em>
                        </template>
                        <b-dropdown-item href="#">Profile</b-dropdown-item>
                        <b-dropdown-item @click="signOut">Sign Out</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    import {checkTokenUrl, signOutUrl} from "@/links";

    export default {
        name: "NavBar",
        props: ['loginStatus'],
        data() {
            return {
                isUserLoggedIn : this.loginStatus
            }
        },
        beforeMount() {
            window.axios.get(checkTokenUrl,{
                headers : {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${sessionStorage.getItem('JWT')}`
                }
            }).then(res => res.data)
                .then(data => this.isUserLoggedIn = data)
            .catch(err => console.log(err))
        }, methods: {
            signOut() {
                window.axios.get(signOutUrl,{
                    headers : {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${sessionStorage.getItem('JWT')}`
                    }
                    // eslint-disable-next-line no-unused-vars
                }).then(response => {
                    sessionStorage.setItem('JWT','');
                    window.router.go()
                }).catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>

</style>