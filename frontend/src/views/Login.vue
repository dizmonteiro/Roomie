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
                      <input class="input" type="text" placeholder="email@example.com" required v-model="email">
                    </div>
                  </div>

                  <div class="field">
                    <label class="label">Password</label>
                    <div class="control">
                      <input class="input" type="password" placeholder="********" required v-model="password">
                    </div>
                  </div>

                  <div class="has-text-centered">
                    <button class="button is-primary" type="submit" >Sign in</button>
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

export default {
  name: 'Login',
  components: {
    DefaultNavbar
  },
  data() {
    return {
      email: '',
      password: '',
    };
  },
  methods: {
    login: function () {
      const { email, password } = this
      this.$store.dispatch(AUTH_REQUEST, { email, password }).then(() => {
        this.$router.push('/')
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