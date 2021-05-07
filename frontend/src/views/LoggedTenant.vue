<template>
  <div>
    <TenantNavbar />
    
    <pagination
      :current="pagination.current"
      :total="pagination.total"
      :itemsPerPage="pagination.itemsPerPage"
      :onChange="onChange"
      :step="1"
    >
    </pagination>
    <div
      class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline"
    >
      <div class="column is-11-mobile is-11-tablet is-11-desktop">
        <div class="columns is-desktop is-mobile is-tablet">
          <div
            class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
          >
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house1.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">1</p>
                  <div class="content has-text-centered">1</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">4</p>
                  <div class="content has-text-centered">4</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">7</p>
                  <div class="content has-text-centered">7</div>
                </div>
              </div>
            </div>
          </div>
          <div
            class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
          >
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house3.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">2</p>
                  <div class="content has-text-centered">2</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">5</p>
                  <div class="content has-text-centered">5</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">8</p>
                  <div class="content has-text-centered">8</div>
                </div>
              </div>
            </div>
          </div>
          <div
            class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
          >
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">3</p>
                  <div class="content has-text-centered">3</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">6</p>
                  <div class="content has-text-centered">6</div>
                </div>
              </div>
            </div>
            <div class="block">
              <div class="card">
                <img
                  object-fit="cover"
                  class="card-icon"
                  :src="require(`@/assets/svg/house2.jpg`)"
                  alt="card icon"
                />
                <div class="card-content">
                  <p class="title has-text-centered is-one-third">9</p>
                  <div class="content has-text-centered">9</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Pagination from "@/components/Pagination.vue";
import TenantNavbar from "@/components/TenantNavbar.vue";

let pagination = {
  current: 1, // Current page
  total: 0, // Items total count
  itemsPerPage: 9, // Items per page
};

export default {
  name: "LoggedTenant",
  components: { Pagination, TenantNavbar },

  data() {
    return {
      allinfo: [
        {
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 2",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1as",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1csa",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1cdsa",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template sda1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template csdac1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1cdsacds",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1cdasc",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template cdas1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template cdsa1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1csda",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1cdas",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1cdas",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
        {
          headline1: "Name Template 1",
          text1: "Template 1",
          imgName1: "house1.jpg",
          link1: "/",
        },
      ],
      column1: [],
      column2: [],
      column3: [],
      indiceatual: 0,
      countries: [],
      pagination: pagination,
      error: "",
    };
  },

  methods: {
    fillColumns(start) {
      var i;
      for (i = start; i < start + 3 && i < this.allinfo.length; i++) {
        this.column1.push(this.allinfo[i]);
      }
      for (i = start + 3; i < start + 6 && i < this.allinfo.length; i++) {
        this.column2.push(this.allinfo[i]);
      }
      for (i = start + 6; i < start + 9 && i < this.allinfo.length; i++) {
        this.column3.push(this.allinfo[i]);
      }
    },

    onChange(page) {
      console.log(`Getting page ${page}`);
      console.log(page);
    },
  },

  created() {
    this.fillColumns(0);
  },
};
</script>

<style scoped>
#content {
  margin: 3% auto 2% auto;
  width: 100%;
}

#checkhouse-card {
  min-height: 80vh;
  margin-top: 2%;
  margin-bottom: 5%;
}

#scroll-area-1 {
  height: 34vh;
}

#scroll-area-2 {
  height: 58vh;
  margin-bottom: 10px;
}

.price-range {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.spacer {
  width: 5px;
}

.vm {
  width: 25%;
  min-width: 70px;
}

.bordera {
  background-color: lightseagreen;
}

.borderb {
  background-color: pink;
}

.borderc {
  background-color: orange;
}

.custom-height {
  min-height: 80vh;
}

.card {
  background-color: white;
  border-radius: 20px;
  box-shadow: 10% rgba(41, 67, 100, 0.21);
  width: 100%;
  height: auto;
  max-height: 450px;
  padding: 10% 10% 10% 10%;
}

.headline {
  font-weight: bold;
}

.card-icon {
  pointer-events: none;
  width: 100%;
  height: auto;
  max-height: 200px;
  padding: 2% 2% 2% 2%;
}

.card-content {
  width: 100%;
  height: auto;
  max-height: 200px;
  padding: 2% 2% 2% 2%;
}
</style>