<template>
    <div>
        <NavBar/>
        <div>
            <b-jumbotron class="text-center">
                <template v-slot:header><img src="../assets/logo.png" style="height:200px"></template>

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
                        <b-col>
                            <b-button variant="primary" href="#">Go to pamphlets</b-button>
                        </b-col>
                        <b-col>
                            <b-button variant="success" href="#">Go to Exams</b-button>
                        </b-col>
                    </b-row>
                </b-container>
            </b-jumbotron>
        </div>
        <div class="footer">
            <div class="first border-bottom border-dark">
                <h3>Footer Content</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias aliquid cum dolorum et fugit id
                    iure libero, maxime molestias nulla obcaecati officia quae quidem quod recusandae rerum tempora,
                    vero. Molestias.</p>
            </div>
            <div class="second border-bottom border-dark">
                <b-container class="text-center">
                    Register for free! <b-button pill variant="danger" class="ml-2">Register</b-button>
                </b-container>
            </div>
            <div class="third border-bottom border-dark">
                <b-container>
                    <span class="copyright-text">Copyright &copy; 2020 All Rights Reserved by
                        <b-link href="#foo" disabled>Ladies Of The Woods</b-link>.</span>
                </b-container>
            </div>
            <div></div>
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

    .first {
        padding-left: 20px;
        display: flex;
        flex-flow: column nowrap;
        align-content: center;
        justify-content: center;
        background-color: #3e4450;
        color: white;
        height: 100px;
    }

    .second {
        display: flex;
        flex-flow: column nowrap;
        align-content: center;
        justify-content: center;
        background-color: #3e4450;
        height: 50px;
        color: white;
    }

    .third {
        display: flex;
        flex-float: column nowrap;
        align-content: center;
        justify-content: center;
        background-color: #333742;
        text-align: center;
        color: white;
    }

    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
    }
</style>