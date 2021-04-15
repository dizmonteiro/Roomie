<template>
  <div id="filler" class="is-flex is-flex-direction-column">
    <DefaultNavbar />
      <div class="columns is-centered is-vcentered is-flex-grow-1">
        <div class="column is-half">
          <div class="card" id="logincard">
            <div class="card-content">
              <p class="title has-text-centered">Welcome</p>
              <form class="login">
                <div class="field">
                  <label class="label">Email</label>
                  <div class="control">
                    <input class="input" type="text" placeholder="email@example.com">
                  </div>
                </div>

                <div class="field">
                  <label class="label">Password</label>
                  <div class="control">
                    <input class="input" type="password" placeholder="********">
                  </div>
                </div>

                <div class="has-text-centered">
                  <button class="button is-primary ">Sign in</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import DefaultNavbar from '@/components/DefaultNavbar'

export default {
  name: 'Login',
  components: {
    DefaultNavbar
  }
}
</script>


<style scoped>
  #filler {
    min-height: 67vh;
  }

  .login {
    margin: 0px 50px;
  }

  @media (max-width: 770px) {
    #logincard{
      margin: 20px 50px 0px 50px;
    }
  }
</style>