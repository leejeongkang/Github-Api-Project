<template>
  <div class="toggle-switch" role="switch">
    <slot></slot>
    <button class="toggle-switch__switch" type="button" aria-selected="false"
            :class="isSwitchOpen ? 'toggle-switch__switch--selected': ''"
            @click="isSwitchOpen = !isSwitchOpen">
      <span class="toggle-switch__handle">
        <span class="ir-pm"></span>
      </span>
    </button>
  </div>
</template>

<script>
export default {
  name: "BaseSwitch",
  data() {
    return {
      isSwitchOpen: false,
    }
  },
  props: {},
  computed: {},
  methods: {}
};
</script>

<style></style>
