
import GroupDescription from './group-description.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 설명 디스크립션',
  components: GroupDescription,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 설명 디스크립션 그룹 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupDescription },
  template: '<GroupDescription></GroupDescription>',
  methods: {}
});
