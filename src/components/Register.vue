<template>
    <div>
        <NavBar/>
        <RegisterForm/>
    </div>
</template>

<script>
    import NavBar from "@/components/NavBar";
    import RegisterForm from "@/components/RegisterForm";
    export default {
        name: "Register",
        components:  {
            NavBar,
            RegisterForm
        }
    }
</script>

<style scoped>

</style>