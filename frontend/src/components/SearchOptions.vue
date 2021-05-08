<template>
  <div class="columns">
    <div
      class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
    >
      <div class="field">
        <p class="control has-icons-left">
          <input class="input" type="search" placeholder="Search" />
          <span class="icon is-small is-left">
            <i class="fas fa-search"></i>
          </span>
        </p>
      </div>
    </div>
    <div
      class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
    >
      <div class="dropdown is-hoverable">
        <div class="dropdown-trigger">
          <button
            class="button"
            aria-haspopup="true"
            aria-controls="dropdown-menu"
          >
            <span>Bedrooms</span>
            <span class="icon is-small">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </div>
        <div class="dropdown-menu" id="dropdown-menu" role="menu">
          <div class="dropdown-content">
            <a class="dropdown-item"> T1 </a>
            <a class="dropdown-item"> T2 </a>
            <a class="dropdown-item"> T3 </a>
            <a class="dropdown-item"> ... </a>
          </div>
        </div>
      </div>
      <div class="dropdown is-hoverable">
        <div class="dropdown-trigger">
          <button
            class="button"
            aria-haspopup="true"
            aria-controls="dropdown-menu"
          >
            <span>Price Range</span>
            <span class="icon is-small">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </div>
        <div class="dropdown-menu" id="dropdown-menu" role="menu">
          <div class="dropdown-content">
            <a class="dropdown-item"> 200€ </a>
            <a class="dropdown-item"> 300€ </a>
            <a class="dropdown-item"> 400€ </a>
            <a class="dropdown-item"> ... </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchOptions",

  data() {
    return {
      bedroomsActive: 0,
      pricesActive: 0,
    };
  },

  mounted() {
    this.paginate();
  },
  methods: {
    clickedBedroom() {
      if (this.bedroomsActive === 0) {
        this.bedroomsActive = 1;
      } else {
        this.bedroomsActive = 0;
      }
    },
    clickedPrices() {
      if (this.pricesActive === 0) {
        this.pricesActive = 1;
      } else {
        this.pricesActive = 0;
      }
    },
  },
};
</script>

<style scoped>

.dropdown {
    padding: 0% 6.5% 0% 0%;
}
</style>