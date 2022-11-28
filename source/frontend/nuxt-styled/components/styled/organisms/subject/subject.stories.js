
import Subject from './Subject.vue';
import {PageHeader} from "@component/styled/organisms/layout/header/header.stories";

export default {
  title: 'Styled/Organisms/[PCFI] 제목',
  components: Subject,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 페이지 상단 타이틀 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { Subject },
  template: '<Subject></Subject>',
});
