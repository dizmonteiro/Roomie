<template>
  <div>
    <DefaultNavbar />

        <div class="columns is-centered is-vcentered" id="content">
          <div class="column is-half">
            <div class="card" id="logincard">
              <div class="card-content">
                <p class="title has-text-centered">Welcome</p>
                <form class="login" @submit.prevent="login">
                  <div class="field">
                    <label class="label">Email</label>
                    <div class="control">
                      <input class="input" type="email" placeholder="email@example.com" required v-model="email">
                    </div>
                  </div>

                  <div class="field">
                    <label class="label">Password</label>
                    <div class="control">
                      <input class="input" type="password" placeholder="********" required v-model="password">
                    </div>
                  </div>

                  <div id="message" v-if="error == 'error' && loaded == 1 ">
                    <p class="help is-danger">Invalid Credentials!</p>
                  </div>

                  <div class="has-text-centered">
                    <button class="button is-green" type="submit" ><strong>Sign in</strong></button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import { AUTH_REQUEST } from "@/store/actions/auth";
import DefaultNavbar from '@/components/DefaultNavbar'
import { mapGetters, mapState } from 'vuex';

export default {
  name: 'Login',
  components: {
    DefaultNavbar
  },
  data() {
    return {
      email: '',
      password: '',
      loaded: 0
    };
  },
  computed: {
    ...mapGetters(["authStatus"]),
    ...mapState({
      error: (state) => `${state.auth.status}`,
    }),
  },
  methods: {
    login: function () {
      const { email, password } = this
      this.loaded++
      this.$store.dispatch(AUTH_REQUEST, { email, password }).then(resp => {
        if(resp == "landlord"){
          this.$router.push("/landlord")
        } else if(resp == "tenant"){
          this.$router.push("/tenant")
        } else {
          this.$router.push("/404")
        }
      })
    }
  }
}
</script>


<style scoped>

  #content {
    margin: 10% auto;
    width: 100%;
  }

  .login {
    margin: 0px 50px;
  }

</style>