<template>
  <nav
    class="navbar is-fixed-top"
    role="navigation"
    aria-label="main navigation"
  >
    <div class="navbar-brand">
      <a class="navbar-item" href="/">
        <img
          src="https://bulma.io/images/bulma-logo.png"
          width="112"
          height="28"
        />
      </a>

      <a
        role="button"
        class="navbar-burger"
        aria-label="menu"
        aria-expanded="false"
        data-target="navbarBasicExample"
      >
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>

      <nav-bar-picture :profilePic="`http://localhost:8083/api/tenants/${id}/avatar`" :w="ppw" :h="pph" :profile="getType" v-if="ww < 1024"/>
        
    </div>
    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button navb">
              <strong>Check Applications</strong>
            </a>
            <a class="button navb" href="/landlord/house/add">
              <strong>Add House</strong>
            </a>
            <a class="button navb" href="/landlord/houses">
              <strong>My Houses</strong>
            </a>
          </div>
        </div>
      </div>
    </div>
    <nav-bar-picture :profilePic="`http://localhost:8083/api/tenants/${id}/avatar`" :w="ppw" :h="pph" :profile="getType" v-if="ww >= 1024"/>
  </nav>
</template>

<script>
import NavBarPicture from './NavBarPicture.vue';
import { mapGetters, mapState } from 'vuex';
export default {
  name: "LandlordNavbar",
  created() {
  window.addEventListener("resize", this.myEventHandler);
},
destroyed() {
  window.removeEventListener("resize", this.myEventHandler);
},
components:{
  NavBarPicture
},
  data(){
    return{
      ww:window.innerWidth,
      lr:false,
      profilePic:"https://source.unsplash.com/random/200x200?sig=1",
      ppw:50,
      pph:50
    }
  },
  methods: {
     myEventHandler() {
       console.log(this.ww)
    if (window.innerWidth < 1024 && !this.lr)
    {
      this.ww=window.innerWidth
      this.lr=true;
    }
    else if (window.innerWidth >= 1024 && this.lr)
    {
      this.ww=window.innerWidth
      this.lr=false;
    }
  },
    
  },
  computed: {
    ...mapGetters(["getType","getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
      id: (state) => `${state.user.id}`,
    }),
  }
};
</script>
<style scoped>
#navbarPP {
  flex-grow: 0;
  background-color: red;
}
strong {
  color: white;
}
.navb {
  border-width: 0;
  background-color: rgba(1, 1, 1, 0);
}
.navbar {
  background-color: #2d6a4f;
}
.profilePic {
  cursor: pointer;
  margin: 0 auto;
  border-radius: 50%;
}

</style>
