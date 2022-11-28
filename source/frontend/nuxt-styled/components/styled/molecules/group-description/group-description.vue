<template lang="html">
 <div>
   <dl class="description">
     <dt class="description__term">
       일반/기관 사용자 회원가입
     </dt>
     <dd class="description__description">
       <ul class="description__list">
         <li>필수항목 : 이름, 아이디, 이메일, 휴대전화번호, 기관구분</li>
         <li>선택항목 : 전화번호, 거주지정보, 설문정보</li>
       </ul>
     </dd>
     <dt class="description__term">
       제공기관 회원가입
     </dt>
     <dd class="description__description">
       <ul class="description__list">
         <li>필수항목 : 이름, 아이디, 이메일, 휴대전화번호, 기관구분</li>
         <li>선택항목 : 전화번호, 거주지정보, 설문정보</li>
       </ul>
     </dd>
     <dt class="description__term">
       그 외 정보
     </dt>
     <dd class="description__description">
       <p class="description__description-text">누구나 동의거부 의사를 표시할 수 있으며 동의 거부시 회원으로써의 기본활동을 위한 정보부족으로 회원가입을 할 수 없으며, 이에따라 홈페이지를 통한 회원 로그인, 회원용 서비스 이용은 제한이 됩니다.</p>
     </dd>
   </dl>
 </div>
</template>

<script type="text/javascript">

export default {
  name: "GroupDescription",
  props: {
  },
  components: {
  }
};
</script>

<style lang="scss">
@import "./group-description.scss";
</style>
