<template>
    <div>
        <b-navbar toggleable="sm" type="dark" variant="dark">
            <b-navbar-brand to="/">Sharif Source</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item v-show="!checkLoginStatus" to="/login">Login</b-nav-item>
                    <b-nav-item v-show="!checkLoginStatus" to="sign-up">Register</b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav v-show="checkLoginStatus" class="ml-auto">
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
    import {signOutUrl} from "@/links";

    export default {
        name: "NavBar",
        data() {
            return {
                isUserLoggedIn : false
            }
        },
        computed : {
            checkLoginStatus() {
                if(sessionStorage.getItem('JWT') !== '') {
                    return true
                }else {
                    return false
                }
            }
        }, methods: {
            signOut() {
                // eslint-disable-next-line no-undef
                axios.get(signOutUrl,{
                    headers : {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${sessionStorage.getItem('JWT')}`
                    }
                    // eslint-disable-next-line no-unused-vars
                }).then(response => {
                    sessionStorage.setItem('JWT','');
                    this.$router.go()
                }).catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>

</style>