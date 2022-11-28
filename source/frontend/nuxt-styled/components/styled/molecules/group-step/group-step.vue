<template lang="html">
<div>
  <!-- step -->
  <div class="step">
    <ol class="step__list" :class="stepClass">
      <li class="step__item step__item--01">
        <strong class="step__title">STEP 1 신청</strong>
        <div class="step__group">
          <span class="step__icon">
            <svg-icon class="svg-icon" name="map" aria-hidden="true"></svg-icon>
          </span>
          <p class="step__text">온라인에서 데이터 <br>신청서 작성</p>
        </div>
      </li>
      <li class="step__item step__item--02">
        <strong class="step__title">STEP 2 검토</strong>
        <div class="step__group">
          <span class="step__icon">
            <svg-icon class="svg-icon" name="outlier" aria-hidden="true"></svg-icon>
          </span>
          <p class="step__text">데이터 제공<br>적합성 검토</p>
        </div>
      </li>
      <li class="step__item step__item--03">
        <strong class="step__title">STEP 3 분석</strong>
        <div class="step__group">
          <span class="step__icon">
            <svg-icon class="svg-icon" name="word-cloud" aria-hidden="true"></svg-icon>
          </span>
          <p class="step__text">데이터 분석 생성</p>
        </div>
      </li>
      <li class="step__item step__item--04">
        <strong class="step__title">STEP 4 제공</strong>
        <div class="step__group">
          <span class="step__icon">
            <svg-icon class="svg-icon" name="bubble" aria-hidden="true"></svg-icon>
          </span>
          <p class="step__text">데이터 분석<br>자료 제공</p>
        </div>
      </li>
    </ol>
  </div>
  <div class="step" style="margin-top: 48px">
    <ol class="step__list step__list--summary">
      <li class="step__item on" title="현재진행페이지 타이틀 필수임"><span class="step__text">현재진행페이지 표시</span></li>
      <li class="step__item"><span class="step__text">정보입력 및 본인인증</span></li>
      <li class="step__item"><span class="step__text">마지막</span></li>
    </ol>
  </div>
</div>
</template>

<script type="text/javascript">

export default {
  name: "GroupStep",
  props:{
    stepClass: {
      type: String,
      default: ""
    }
  },
  components: {

  },
  data() {
    return {
    };
  }
};
</script>

<style lang="scss">
@import "./group-step.scss";
</style>
