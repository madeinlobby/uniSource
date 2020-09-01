<template>
    <div>
        <NavBar/>
        <div>
            <b-jumbotron class="text-center">
                <template v-slot:header>UNI DOCKS</template>

                <template v-slot:lead>
                    All the questions you would ever need.

                </template>

                <hr class="my-4">

                <b-container class="bv-example-row">
                    <b-row>
                        <b-col><h3>Great pamphlets</h3></b-col>
                        <b-col><h3>Special Exams</h3></b-col>
                    </b-row>
                    <b-row class="text-center">
                        <b-col>With Sharif Source, you can access all pamphlets you need with a click!</b-col>
                        <b-col>In Sharif Source, we have gathered quizzes, midterms and finals you need.</b-col>
                    </b-row>
                    <b-row class="mt-3">
                        <b-col><b-button variant="primary" href="#">Go to pamphlets</b-button></b-col>
                        <b-col><b-button variant="success" href="#">Go to Exams</b-button></b-col>
                    </b-row>
                </b-container>
            </b-jumbotron>
        </div>
    </div>
</template>

<script>
    import NavBar from "@/components/NavBar";

    export default {
        name: "Home",
        components: {
            NavBar
        }
    }
</script>

<style scoped>

</style>