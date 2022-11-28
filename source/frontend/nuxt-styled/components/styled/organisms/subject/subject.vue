<template lang="html">
  <div class="subject">
    <div class="subject__wrap">
      <div class="subject__menu-img-box">
        <svg-icon class="svg-icon" name="map-shape" aria-hidden="true"></svg-icon>
      </div>
      <div class="subject__title-wrap">
        <h3 class="subject__title">subject-title</h3>
        <p class="subject__desc">subject-desc 메뉴별 왼쪽아이콘 + 타이틀 + 설명글이 들어갑니다.</p>
        <ul class="subject__list">
          <li class="subject__list-item">support-explain</li>
          <li class="subject__list-item">문의 주신 내용은 충분한 검토 및 확인 후 답변 드리겠습니다.</li>
        </ul>
      </div>
      <div class="subject__sub-group">
        <button type="button" class="button button--primary button--lg"><span class="button__text">button</span></button>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">

export default {
  name: "Subject",
  extends: {},
  props: {},
  computed: {},
  components: {},
  watch: {},
  methods: {}
};
</script>

<style lang="scss" scoped>
@import "./subject.scss";
</style>
